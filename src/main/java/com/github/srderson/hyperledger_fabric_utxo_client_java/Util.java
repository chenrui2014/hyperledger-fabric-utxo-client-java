package com.github.srderson.hyperledger_fabric_utxo_client_java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Util {

	public static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();


	public static byte[] readBytesToByteArrayOutputStream(RandomAccessFile file, int bytesToRead, ByteArrayOutputStream baos) throws IOException {
		byte[] bytes = new byte[bytesToRead];
		int bytesRead = file.read(bytes);
		if(bytesRead != bytesToRead) {
			throw new IOException("Error reading bytes from file");
		}
		baos.write(bytes);
		return bytes;
	}


	public static long readVariableLengthInt(RandomAccessFile file) throws IOException {
		byte[] b = readVariableLengthIntBytes(file);
		return getVariableLengthInt(b);
	}

	public static long getVariableLengthInt(byte[] bytes) {
		long retVal = 0;
		if(bytes.length == 1) {
			retVal = bytes[0] & 0xff;
		} else if(bytes.length == 3) {
			retVal = bytesToLittleEndianUint16(Arrays.copyOfRange(bytes, 1, 3));
		} else if(bytes.length == 5) {
			retVal = bytesToLittleEndianUint32(Arrays.copyOfRange(bytes, 1, 5));
		} else if(bytes.length == 9) {
			retVal = bytesToLittleEndianUint64(Arrays.copyOfRange(bytes, 1, 9));
		}
		return retVal;
	}

	public static byte[] readVariableLengthIntBytes(RandomAccessFile file) throws IOException {
		ByteArrayOutputStream retVal = new ByteArrayOutputStream();
		byte variableLenIntByte = file.readByte();
		retVal.write(variableLenIntByte);
		int variableLenInt = variableLenIntByte & 0xff;
		if(variableLenInt == 253) {
			byte[] transactionCountBytes = new byte[2];
			file.read(transactionCountBytes);
			retVal.write(transactionCountBytes);
		} else if(variableLenInt == 254) {
			byte[] transactionCountBytes = new byte[4];
			file.read(transactionCountBytes);
			retVal.write(transactionCountBytes);
		} else if(variableLenInt == 255) {
			byte[] transactionCountBytes = new byte[8];
			file.read(transactionCountBytes);
			retVal.write(transactionCountBytes);
		}
		return retVal.toByteArray();
	}

	public static short bytesToLittleEndianUint16(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getShort();
	}

	public static int bytesToLittleEndianUint32(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
	}

	public static long bytesToLittleEndianUint64(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getLong();
	}

	public static String byteArrayToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for(int i=0; i<bytes.length; i++) {
			int v = bytes[i] & 0xFF;
			hexChars[i * 2] = HEX_ARRAY[v >>> 4];
			hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

}
