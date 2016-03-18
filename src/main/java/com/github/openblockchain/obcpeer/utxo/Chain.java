package com.github.openblockchain.obcpeer.utxo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Chain {
	
	public static final byte[] TESTNET3_MAGIC_ID = Util.hexStringToByteArray("0B110907");
	public static final byte[] MAINNET_MAGIC_ID = Util.hexStringToByteArray("F9BEB4D9");
	
	public static final String BLK_FILE_PREFIX = "blk";
	public static final String BLK_FILE_SUFFIX = ".dat";
	
	public final String CHAIN_FOLDER;
	private final byte[] EXPECTED_MAGIC_ID;
	
	private Map<String, Block> previousHashToBlockMap;
	private Block genesisBlock = null;
	private Block previousBlock = null;
	boolean first = true;
	
	public Chain(String chainFolder, boolean isTestnet) throws IOException {
		
		EXPECTED_MAGIC_ID = isTestnet ? TESTNET3_MAGIC_ID : MAINNET_MAGIC_ID;

		if(!chainFolder.endsWith("/")) {
			chainFolder += "/";
		}
		this.CHAIN_FOLDER = chainFolder;
		
		previousHashToBlockMap = new HashMap<String, Block>();
		
		int blkFileCount = 0;
		String blkFileName = getBlkFileName(blkFileCount);
		RandomAccessFile file = new RandomAccessFile(new File(chainFolder + blkFileName), "r");
		
		int blockCount = -1;
		
		while(file != null) {
			try {

				while(file.getFilePointer() < file.length()) {
					
					blockCount++;
					System.out.println("\nLoading block: " + blockCount);
				
					long blockOffset = file.getFilePointer();
					System.out.println("Block file: " + blkFileName);
					System.out.println("Block offset: " + blockOffset);
					
					// read magic ID
					byte[] magicID = new byte[4];
					file.read(magicID);
					if(!Arrays.equals(EXPECTED_MAGIC_ID, magicID)) {
						System.out.println("Error reading magic ID. Expected " + EXPECTED_MAGIC_ID + " but got " + magicID);
						System.out.println("Assume end of chain");
//						throw new RuntimeException();
						return;
					}
					
					// read length
					byte[] blockLengthBytes = new byte[4];
					file.read(blockLengthBytes);
					int blockLength = Util.bytesToLittleEndianUint32(blockLengthBytes);
					
					// skip the version
					file.skipBytes(4);
					
					// read the previous block hash
					byte[] previousBlockHash = new byte[32];
					int bytesRead = file.read(previousBlockHash);
					if(bytesRead != 32) {
						throw new IOException("Error reading previous block hash");
					}
					
					Block block = new Block(CHAIN_FOLDER+blkFileName, blockOffset);
					previousHashToBlockMap.put(new StringBuilder(Util.byteArrayToHex(previousBlockHash)).reverse().toString(), block);
					
					if(genesisBlock == null) {
						genesisBlock = block;
					}
						
					file.skipBytes(blockLength-36);
					
				}
				
			} finally {
				if(file != null) {
					file.close();
				}
			}
			
			blkFileCount++;
			blkFileName = getBlkFileName(blkFileCount);
			try {
				file = new RandomAccessFile(new File(chainFolder + blkFileName), "r");
			} catch(FileNotFoundException f) {
				// End of the chain
				file = null;
			}
			
		}
		
			
	}
	
	public Block nextBlock() throws IOException {
		if(first) {
			first = false;
			previousBlock = genesisBlock;
			return genesisBlock;
		} else if(previousBlock == null) {
			return null;	
		} else {
			Block block = previousHashToBlockMap.get(previousBlock.getBlockHash());
			previousBlock = block;
			return block;
		}
	}
	
	private String getBlkFileName(int count) {
		StringBuilder sb = new StringBuilder();
		sb.append(BLK_FILE_PREFIX);
		sb.append(String.format("%05d", count));
		sb.append(BLK_FILE_SUFFIX);
		return sb.toString();
	}
	

}
