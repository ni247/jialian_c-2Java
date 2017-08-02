package com.csii.pccc.core;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64DecoderStream extends FilterInputStream {

	private byte buffer[];
	private int bufsize;
	private int index;
	private byte input_buffer[];
	private int input_pos;
	private int input_len;
	private boolean ignoreErrors;
	private static final char pem_array[] =
		{
			'A',
			'B',
			'C',
			'D',
			'E',
			'F',
			'G',
			'H',
			'I',
			'J',
			'K',
			'L',
			'M',
			'N',
			'O',
			'P',
			'Q',
			'R',
			'S',
			'T',
			'U',
			'V',
			'W',
			'X',
			'Y',
			'Z',
			'a',
			'b',
			'c',
			'd',
			'e',
			'f',
			'g',
			'h',
			'i',
			'j',
			'k',
			'l',
			'm',
			'n',
			'o',
			'p',
			'q',
			'r',
			's',
			't',
			'u',
			'v',
			'w',
			'x',
			'y',
			'z',
			'0',
			'1',
			'2',
			'3',
			'4',
			'5',
			'6',
			'7',
			'8',
			'9',
			'+',
			'/' };
	private static final byte pem_convert_array[];

	static {
		pem_convert_array = new byte[256];
		for (int i = 0; i < 255; i++)
			pem_convert_array[i] = -1;

		for (int j = 0; j < pem_array.length; j++)
			pem_convert_array[pem_array[j]] = (byte) j;

	}

	public Base64DecoderStream(InputStream inputstream) {
		super(inputstream);
		buffer = new byte[3];
		bufsize = 0;
		index = 0;
		input_buffer = new byte[8190];
		input_pos = 0;
		input_len = 0;
		try {
			String s = System.getProperty("com.spdb.security.base64.ignoreerrors");
			ignoreErrors = "true".equalsIgnoreCase(s);
		} catch (SecurityException securityexception) {
		}
	}

	public Base64DecoderStream(InputStream inputstream, boolean flag) {
		super(inputstream);
		buffer = new byte[3];
		bufsize = 0;
		index = 0;
		input_buffer = new byte[8190];
		input_pos = 0;
		input_len = 0;
		ignoreErrors = flag;
	}

	public int read() throws IOException {
		if (index >= bufsize) {
			bufsize = decode(buffer, 0, buffer.length);
			if (bufsize <= 0)
				return -1;
			index = 0;
		}
		return buffer[index++] & 0xff;
	}

	public int read(byte abyte0[], int i, int j) throws IOException {
		int k = i;
		for (; index < bufsize && j > 0; j--)
			abyte0[i++] = buffer[index++];

		if (index >= bufsize)
			bufsize = index = 0;
		int l = (j / 3) * 3;
		if (l > 0) {
			int i1 = decode(abyte0, i, l);
			i += i1;
			j -= i1;
			if (i1 != l)
				if (i == k)
					return -1;
				else
					return i - k;
		}
		for (; j > 0; j--) {
			int j1 = read();
			if (j1 == -1)
				break;
			abyte0[i++] = (byte) j1;
		}

		if (i == k)
			return -1;
		else
			return i - k;
	}

	public boolean markSupported() {
		return false;
	}

	public int available() throws IOException {
		return (in.available() * 3) / 4 + (bufsize - index);
	}

	private int decode(byte abyte0[], int i, int j) throws IOException {
		int k = i;
		while (j >= 3) {
			int l = 0;
			int i1;
			int j1;
			for (i1 = 0; l < 4; i1 |= j1) {
				j1 = getByte();
				if (j1 == -1 || j1 == -2) {
					boolean flag;
					if (j1 == -1) {
						if (l == 0)
							return i - k;
						if (!ignoreErrors)
							throw new IOException(
								(
									new StringBuffer("Error in encoded stream: needed 4 valid base64 characters but only got "))
									.append(l)
									.append(" before EOF")
									.append(recentChars())
									.toString());
						flag = true;
					} else {
						if (l < 2 && !ignoreErrors)
							throw new IOException(
								(
									new StringBuffer("Error in encoded stream: needed at least 2 valid base64 characters, but only got "))
									.append(l)
									.append(" before padding character (=)")
									.append(recentChars())
									.toString());
						if (l == 0)
							return i - k;
						flag = false;
					}
					int k1 = l - 1;
					if (k1 == 0)
						k1 = 1;
					l++;
					i1 <<= 6;
					for (; l < 4; l++) {
						if (!flag) {
							j1 = getByte();
							if (j1 == -1) {
								if (!ignoreErrors)
									throw new IOException(
										(
											new StringBuffer("Error in encoded stream: hit EOF while looking for padding characters (=)"))
											.append(recentChars())
											.toString());
							} else if (j1 != -2 && !ignoreErrors)
								throw new IOException(
									(
										new StringBuffer("Error in encoded stream: found valid base64 character after a padding character (=)"))
										.append(recentChars())
										.toString());
						}
						i1 <<= 6;
					}

					i1 >>= 8;
					if (k1 == 2)
						abyte0[i + 1] = (byte) (i1 & 0xff);
					i1 >>= 8;
					abyte0[i] = (byte) (i1 & 0xff);
					j -= k1;
					i += k1;
					return i - k;
				}
				i1 <<= 6;
				l++;
			}

			abyte0[i + 2] = (byte) (i1 & 0xff);
			i1 >>= 8;
			abyte0[i + 1] = (byte) (i1 & 0xff);
			i1 >>= 8;
			abyte0[i] = (byte) (i1 & 0xff);
			j -= 3;
			i += 3;
		}
		return i - k;
	}

	private int getByte() throws IOException {
		int i;
		do {
			if (input_pos >= input_len) {
				try {
					input_len = in.read(input_buffer);
				} catch (EOFException eofexception) {
					return -1;
				}
				if (input_len <= 0)
					return -1;
				input_pos = 0;
			}
			i = input_buffer[input_pos++] & 0xff;
			if (i == 61)
				return -2;
			i = pem_convert_array[i];
		} while (i == -1);
		return i;
	}

	private String recentChars() {
		StringBuffer s = new StringBuffer();
		int i = input_pos > 10 ? 10 : input_pos;
		if (i > 0) {
			s.append(", the ").append(i).append(" most recent characters were: \"");
			for (int j = input_pos - i; j < input_pos; j++) {
				char c = (char) (input_buffer[j] & 0xff);
				switch (c) {
					case 13 : // '\r'
						s.append("\\r");
						break;

					case 10 : // '\n'
						s.append("\\n");
						break;

					case 9 : // '\t'
						s.append("\\t");
						break;

					case 11 : // '\013'
					case 12 : // '\f'
					default :
						if (c >= ' ' && c < '\177')
							s.append(c);
						else
							s.append("\\").append(c);
						break;
				}
			}

			s.append("\"");
		}
		return s.toString();
	}

	public static byte[] decode(byte abyte0[]) {
		int i = (abyte0.length / 4) * 3;
		if (i == 0)
			return abyte0;
		if (abyte0[abyte0.length - 1] == 61) {
			i--;
			if (abyte0[abyte0.length - 2] == 61)
				i--;
		}
		byte abyte1[] = new byte[i];
		int k = 0;
		int l = 0;
		for (int j = abyte0.length; j > 0; j -= 4) {
			int j1 = 3;
			int i1 = pem_convert_array[abyte0[k++] & 0xff];
			i1 <<= 6;
			i1 |= pem_convert_array[abyte0[k++] & 0xff];
			i1 <<= 6;
			if (abyte0[k] != 61)
				i1 |= pem_convert_array[abyte0[k++] & 0xff];
			else
				j1--;
			i1 <<= 6;
			if (abyte0[k] != 61)
				i1 |= pem_convert_array[abyte0[k++] & 0xff];
			else
				j1--;
			if (j1 > 2)
				abyte1[l + 2] = (byte) (i1 & 0xff);
			i1 >>= 8;
			if (j1 > 1)
				abyte1[l + 1] = (byte) (i1 & 0xff);
			i1 >>= 8;
			abyte1[l] = (byte) (i1 & 0xff);
			l += j1;
		}

		return abyte1;
	}

}