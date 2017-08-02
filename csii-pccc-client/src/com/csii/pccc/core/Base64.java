package com.csii.pccc.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
 * 
 * 
 * 
 * 
 * @author zenggang 
 * @version 1.0.0
 * @since 1.0.0
 */
public class Base64 {

	public static InputStream decode(InputStream is) {
		return new Base64DecoderStream(is);
	}

	public static byte[] decode(byte bytes[]) {
		return decode(bytes, 0, bytes.length);
	}

	public static byte[] decode(byte bytes[], int offset, int len) {
		try {
			byte buf[] = new byte[1024];

			ByteArrayOutputStream out;
			InputStream in = decode(((InputStream) (new ByteArrayInputStream(bytes, offset, len))));
			out = new ByteArrayOutputStream();
			int n;
			while ((n = in.read(buf)) > 0)
				out.write(buf, 0, n);
			in.close();
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] decode(String base64) {
		return decode(base64.getBytes());
	}

	public static String decodeAsString(byte bytes[]) {
		return new String(decode(bytes));
	}

	public static String decodeAsString(String str) {
		return decodeAsString(str.getBytes());
	}

	public static OutputStream encode(OutputStream os) {
		return new Base64EncoderStream(os);
	}

	public static byte[] encode(byte bytes[]) {
		return encode(bytes, 0, bytes.length);
	}

	public static byte[] encode(byte bytes[], int offset, int len) {
		try {
			ByteArrayOutputStream out;
			out = new ByteArrayOutputStream();
			OutputStream encoderStream = encode(((OutputStream) (out)));
			encoderStream.write(bytes, offset, len);
			encoderStream.flush();
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String encodeAsString(byte bytes[]) {
		return new String(encode(bytes));
	}

	public static String encodeAsString(String str) {
		return encodeAsString(str.getBytes());
	}

	public static void main(String args[]) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: java Base64 [enc|dec] yourStrings");
			System.exit(0);
		}
		String str1 = args[0].trim();
		if (str1.equalsIgnoreCase("enc"))
			System.out.println(encodeAsString(args[1]));
		else if (str1.equalsIgnoreCase("dec"))
			System.out.println(decodeAsString(args[1]));
		else
			System.err.println("Usage: java Base64 encORdec yourStrings");
	}
}