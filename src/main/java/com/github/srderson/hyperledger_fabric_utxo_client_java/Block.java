package com.github.srderson.hyperledger_fabric_utxo_client_java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Block {

	private String file;
	private long offset;

	public Block(String file, long offset) {
		this.file = file;
		this.offset = offset;
	}

	public List<byte[]> getTransactions() throws IOException {

		List<byte[]> transactions = new ArrayList<byte[]>();

		RandomAccessFile raf = null;
		try {

			raf = new RandomAccessFile(new File(file), "r");
			raf.seek(offset);
			raf.skipBytes(88);

			long transactionCount = Util.readVariableLengthInt(raf);
			for(int i=0; i<transactionCount; i++) {

				// transaction bytes
				ByteArrayOutputStream transactionBytes = new ByteArrayOutputStream();

				// transaction version number
				Util.readBytesToByteArrayOutputStream(raf, 4, transactionBytes);

				// number of inputs
				byte[] inputCountBytes = Util.readVariableLengthIntBytes(raf);
				transactionBytes.write(inputCountBytes);
				long inputCount = Util.getVariableLengthInt(inputCountBytes);

				for(int j=0; j<inputCount; j++) {

					// transaction hash = 32 bytes
					// transaction index = 4 bytes
					Util.readBytesToByteArrayOutputStream(raf, 36, transactionBytes);

					// script length
					byte[] scriptLengthBytes = Util.readVariableLengthIntBytes(raf);
					transactionBytes.write(scriptLengthBytes);
					int scriptLength = (int)Util.getVariableLengthInt(scriptLengthBytes);
					//System.out.println("Script length input: " + j + "->" + scriptLength);

					// script
					Util.readBytesToByteArrayOutputStream(raf, scriptLength, transactionBytes);

					// sequence number
					Util.readBytesToByteArrayOutputStream(raf, 4, transactionBytes);

				}

				// number of outputs
				byte[] outputCountBytes = Util.readVariableLengthIntBytes(raf);
				transactionBytes.write(outputCountBytes);
				long outputCount = Util.getVariableLengthInt(outputCountBytes);
				//System.out.println("Output count: " + outputCount);

				for(int j=0; j<outputCount; j++) {

					// value
					Util.readBytesToByteArrayOutputStream(raf, 8, transactionBytes);

					// script length
					byte[] scriptLengthBytes = Util.readVariableLengthIntBytes(raf);
					transactionBytes.write(scriptLengthBytes);
					int scriptLength = (int)Util.getVariableLengthInt(scriptLengthBytes);

					// script
					Util.readBytesToByteArrayOutputStream(raf, scriptLength, transactionBytes);

				}

				// lock time
				Util.readBytesToByteArrayOutputStream(raf, 4, transactionBytes);

				transactions.add(transactionBytes.toByteArray());
			}
		} finally {
			if(raf != null) {
				raf.close();
			}
		}

		return transactions;
	}

	public String getBlockHash() throws IOException {
		RandomAccessFile raf = null;
		byte[] bytes = new byte[80];
		try {
			raf = new RandomAccessFile(new File(file), "r");
			raf.seek(offset);

			// skip magic ID and block length
			raf.skipBytes(8);

			int bytesRead = raf.read(bytes);
			if(bytesRead != 80) {
				throw new IOException("Error reading block prefix");
			}
		} finally {
			if(raf != null) {
				raf.close();
			}
		}
		String blockHash;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(digest.digest(bytes));
			blockHash = new StringBuilder(Util.byteArrayToHex(hash)).reverse().toString();
		} catch (NoSuchAlgorithmException e) {
			// this should not happen
			throw new RuntimeException(e);
		}
		return blockHash;
	}

	public static void printTransactionHashes(List<byte[]> transactions) {
		for(int k=0; k<transactions.size(); k++) {
			byte[] transaction = transactions.get(k);
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(digest.digest(transaction));
				System.out.println("Transacion " + k + ": " + new StringBuilder(Util.byteArrayToHex(hash)).reverse().toString());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		}
	}

}
