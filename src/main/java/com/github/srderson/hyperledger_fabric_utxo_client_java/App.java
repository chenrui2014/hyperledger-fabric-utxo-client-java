package com.github.srderson.hyperledger_fabric_utxo_client_java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class App {

	public static void main(String[] args) {

		String chainFolder = null;
		boolean testnet;
		int maxBlocks;
		String chaincodeName = null;
		String peerHost = null;
		int peerPort;

		InputStream in = null;
		try {
			Properties prop = new Properties();
			in = App.class.getResourceAsStream("config.properties");
			prop.load(in);
			chainFolder = prop.getProperty("chain_folder");
			testnet = new Boolean(prop.getProperty("testnet")).booleanValue();
			maxBlocks = Integer.parseInt(prop.getProperty("max_blocks"));
			chaincodeName = prop.getProperty("chaincode_name");
			peerHost = prop.getProperty("peer_host");
			peerPort = Integer.parseInt(prop.getProperty("peer_port"));
		} catch(IOException e) {
			throw new RuntimeException(e);
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		try {
			Chain chain = new Chain(chainFolder, testnet);

			// gRPC connection to the peer
			Client client = new Client(peerHost, peerPort);

			Block block = chain.nextBlock();
			int i=0;
			while(block != null && (maxBlocks == -1 || i < maxBlocks)) {
				System.out.println("\nBlock: " + i);
				System.out.println("Block hash: " + block.getBlockHash());
				System.out.println("Transaction count: " + block.getTransactions().size());

				List<byte[]> transactions = block.getTransactions();
				for(byte[] transactionBytes : transactions) {
					client.invoke(chaincodeName, transactionBytes);
				}

				//Block.printTransactionHashes(block.getTransactions());
				i++;
				block = chain.nextBlock();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
