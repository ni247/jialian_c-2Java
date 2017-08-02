package com.csii.pccc.core;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64EncoderStream extends FilterOutputStream {

	private byte buffer[];
	private int bufsize;
	private int count;
	private int bytesPerLine;
	private int lineLimit;
	private boolean noCRLF;
	private static byte newline[] = { 13, 10 };
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

	public Base64EncoderStream(OutputStream outputstream, int i) {
		super(outputstream);
		bufsize = 0;
		count = 0;
		noCRLF = false;
		buffer = new byte[3];
		if (i == 0x7fffffff || i < 4) {
			noCRLF = true;
			i = 76;
		}
		bytesPerLine = (i / 4) * 4;
		lineLimit = (i / 4) * 3;
	}

	public Base64EncoderStream(OutputStream outputstream) {
		this(outputstream, 76);
	}

	public void write(byte abyte0[], int i, int j) throws IOException {
		for (;(bufsize != 0 || count != 0) && j > 0; j--)
			write(abyte0[i++]);

		byte abyte1[];
		if (noCRLF) {
			abyte1 = new byte[bytesPerLine];
		} else {
			abyte1 = new byte[bytesPerLine + 2];
			abyte1[bytesPerLine] = 13;
			abyte1[bytesPerLine + 1] = 10;
		}
		int k;
		for (k = 0; k + lineLimit < j; k += lineLimit)
			out.write(encode(abyte0, i + k, lineLimit, abyte1));

		for (; k < j; k++)
			write(abyte0[i + k]);

	}

	public void write(byte abyte0[]) throws IOException {
		write(abyte0, 0, abyte0.length);
	}

	public void write(int i) throws IOException {
		buffer[bufsize++] = (byte) i;
		if (bufsize == 3) {
			encode();
			bufsize = 0;
		}
	}

	public void flush() throws IOException {
		if (bufsize > 0) {
			encode();
			bufsize = 0;
		}
		out.flush();
	}

	public void close() throws IOException {
		flush();
		out.close();
	}

	private void encode() throws IOException {
		if (count + 4 > bytesPerLine) {
			if (!noCRLF)
				out.write(newline);
			count = 0;
		}
		out.write(encode(buffer, 0, bufsize, null));
		count += 4;
	}

	public static byte[] encode(byte abyte0[]) {
		if (abyte0.length == 0)
			return abyte0;
		else
			return encode(abyte0, 0, abyte0.length, null);
	}

	private static byte[] encode(byte abyte0[], int i, int j, byte abyte1[]) {
		if (abyte1 == null)
			abyte1 = new byte[((j + 2) / 3) * 4];
		int k = i;
		int l;
		for (l = 0; j >= 3; l += 4) {
			int i1 = abyte0[k++] & 0xff;
			i1 <<= 8;
			i1 |= abyte0[k++] & 0xff;
			i1 <<= 8;
			i1 |= abyte0[k++] & 0xff;
			abyte1[l + 3] = (byte) pem_array[i1 & 0x3f];
			i1 >>= 6;
			abyte1[l + 2] = (byte) pem_array[i1 & 0x3f];
			i1 >>= 6;
			abyte1[l + 1] = (byte) pem_array[i1 & 0x3f];
			i1 >>= 6;
			abyte1[l + 0] = (byte) pem_array[i1 & 0x3f];
			j -= 3;
		}

		if (j == 1) {
			int j1 = abyte0[k++] & 0xff;
			j1 <<= 4;
			abyte1[l + 3] = 61;
			abyte1[l + 2] = 61;
			abyte1[l + 1] = (byte) pem_array[j1 & 0x3f];
			j1 >>= 6;
			abyte1[l + 0] = (byte) pem_array[j1 & 0x3f];
		} else if (j == 2) {
			int k1 = abyte0[k++] & 0xff;
			k1 <<= 8;
			k1 |= abyte0[k++] & 0xff;
			k1 <<= 2;
			abyte1[l + 3] = 61;
			abyte1[l + 2] = (byte) pem_array[k1 & 0x3f];
			k1 >>= 6;
			abyte1[l + 1] = (byte) pem_array[k1 & 0x3f];
			k1 >>= 6;
			abyte1[l + 0] = (byte) pem_array[k1 & 0x3f];
		}
		return abyte1;
	}

}