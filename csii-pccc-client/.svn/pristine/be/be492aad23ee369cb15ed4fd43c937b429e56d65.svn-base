/*
 * @(#)Signature.java	1.0 2010-11-8 下午08:13:02
 *
 * Copyright 2004-2010 Client Service International, Inc. All rights reserved.
 * CSII PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.csii.pccc.core;

import java.io.ByteArrayOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;

import javax.crypto.Cipher;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.csii.pccc.exception.SignException;
import com.csii.pccc.util.Assert;
import com.csii.pe.common.security.DigitalSignatureUtil;

/**
 * Signature.java 签名类。提供数字签名及数字签名验证方法
 *
 *         <p>
 *         Created on 2010-11-8 Modification history
 *         </p>
 *         <p>
 *         IBS Product Expert Group, CSII Powered by CSII PowerEngine 6.0
 *         </p>
 * @version 1.0
 * @since 1.0
 */
public class Signature {

	private static final String MD5WITHRSA_ALGORITHM = "MD5withRSA";
	
	private static final String SHA1WITHRSA_ALGORITHM = "SHA1WithRSA";

	private static final String ALGORITHM = "RSA";
	
	 /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;
    
    /** *//**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 117;
    
    private static BouncyCastleProvider bouncyCastleProvider= new org.bouncycastle.jce.provider.BouncyCastleProvider();
	
	/**
	 * 将字节数组转换为16进制字符串 算法： 将字节数组中每个字节取出后转换为16进制，截取低八位 将不足2位的字符前补0，解析时可按2位分隔
	 * 
	 * @param byteArray
	 *            字节数组
	 * @return 16进制字符
	 */
	private String byteToHex(byte[] byteArray) {
		if (byteArray == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			String hexString = Integer.toHexString(byteArray[i] & 0x00ff);
			if (hexString.length() != 2) {
				// 如果字符长度不为2位，前补0占位
				sb.append("0");
			}
			sb.append(hexString);
		}
		return sb.toString();
	}

	/**
	 * 将16进制字符串转换为字节数组 算法： 每2位为一个字符，将该16进制字符转换为字节
	 * 
	 * @param hexString
	 *            16进制字符串
	 * @return 字符数组
	 */
	private byte[] hexToByte(String hexString) {
		if (hexString == null || hexString.trim().length() == 0) {
			return new byte[0];
		}
		// 按2位计算字符个数
		int unit = hexString.length() / 2;
		// 结果字符数组，初始长度为unit
		byte[] byteArray = new byte[unit];

		for (int i = 0; i < hexString.length() / 2; i++) {
			// 截取字符
			String hexChar = hexString.substring(i * 2, i * 2 + 2);
			// 将16进制转换为字节
			byteArray[i] = (byte) Integer.parseInt(hexChar, 16);
		}
		return byteArray;
	}

	/**
	 * 使用提供的算法与私钥对交易数据签名
	 * 
	 * @param plain
	 *            交易数据明文
	 * @param algorithm
	 *            签名算法
	 * @param privateKey
	 *            java.security.PrivateKey 私钥
	 * @return 签名
	 * @throws SignException
	 *             签名异常
	 */
	public String sign(String plain, String algorithm, PrivateKey privateKey) {
		try {
			Assert.notNull(plain, "plain is null.");
			Assert.notNull(algorithm, "algorithm is null.");
			Assert.notNull(privateKey, "private key is null.");

			java.security.Signature sign = java.security.Signature.getInstance(algorithm);
			sign.initSign(privateKey);
			sign.update(plain.getBytes());
			return byteToHex(sign.sign());
		} catch (Exception ex) {
			throw new SignException(ex);
		}
	}

	/**
	 * 验证16进制签名
	 * 
	 * @param plain
	 *            交易数据明文
	 * @param signature
	 *            签名
	 * @param algorithm
	 *            签名算法
	 * @param publicKey
	 *            java.security.PublicKey 公钥
	 * @return 验证是否成功
	 * @throws VerifyException
	 *             验签异常
	 */
	public boolean verify(String plain, String signature, String algorithm, PublicKey publicKey) {
		try {
			Assert.notNull(plain, " plain is null.");
			Assert.notNull(signature, "signature is null.");
			Assert.notNull(algorithm, "algorithm is null.");
			Assert.notNull(publicKey, "public key is null.");

			java.security.Signature sign = java.security.Signature.getInstance(algorithm);
			sign.initVerify(publicKey);
			sign.update(plain.getBytes());
			byte[] signatureByteArray = hexToByte(signature); // 转换为字节数组
			return sign.verify(signatureByteArray);
		} catch (Exception ex) {
			throw new SignException(ex);
		}
	}
	
	/**
	 * 
	 * @param plain
	 * @param signature
	 * @param algorithm
	 * @param certificate
	 * @return
	 * @author ZhangJianBing
	 * @date 2015-5-27
	 */
	public boolean verify(String plain, String signature, String algorithm, X509Certificate certificate, String chaset) {
		try {
			if (null == chaset) {
				chaset = "utf-8";
			}
//			BASE64Decoder decoder = new BASE64Decoder();
			return DigitalSignatureUtil.verify(certificate, algorithm, plain.getBytes(chaset), /*decoder.decodeBuffer(signature)*/Base64.decode(signature));
		} catch (Exception ex) {
			throw new SignException(ex);
		}
	}
	
	/**
	 * 使用MD5withRSA算法对签名进行验证
	 * 
	 * @param plain
	 *            交易数据明文
	 * @param signature
	 *            交易签名
	 * @param publicKey
	 *            公钥
	 * @return 验证签名是否正确
	 * @throws VerifyException
	 *             验签异常
	 */
	public boolean verifyByMD5withRSA(String plain, String signature, PublicKey publicKey) {
		return verify(plain, signature, MD5WITHRSA_ALGORITHM, publicKey);
	}

	/**
	 * 使用MD5withRSA算法对交易数据进行签名
	 * 
	 * @param plain
	 *            交易数据明文
	 * @param privateKey
	 *            私钥
	 * @return 交易签名
	 * @throws SignException
	 *             签名异常
	 */
	public String signByMD5withRSA(String plain, PrivateKey privateKey) {
		return sign(plain, MD5WITHRSA_ALGORITHM, privateKey);
	}
	
	/**
     * <p>
     * 公钥加密
     * </p>
     * 
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public String encryptByPublicKey(String data, PublicKey publicKey){
    	try {
    		byte[] db = data.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("RSA",bouncyCastleProvider
					);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(db.length);// 获得加密块加密后块大小
			int leavedSize = db.length % blockSize;
			int blocksSize = leavedSize != 0 ? db.length / blockSize + 1
					: db.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (db.length - i * blockSize > 0) {
				if (db.length - i * blockSize > blockSize)
					cipher.doFinal(db, i * blockSize, blockSize, raw, i
							* outputSize);
				else
					cipher.doFinal(db, i * blockSize, db.length - i
							* blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return byteToHex(raw);
		} catch (Exception ex) {
			throw new SignException(ex);
		}
    }
    
	/**
     * <P>
     * 私钥解密
     * </p>
     * 
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public String decryptByPrivateKey(String encryptedData, PrivateKey privateKey){
    	try {
    		byte[] raw = hexToByte(encryptedData);
    		Cipher cipher = Cipher.getInstance("RSA",
    				bouncyCastleProvider);
			cipher.init(cipher.DECRYPT_MODE, privateKey);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			
			return new String(bout.toByteArray());
    	} catch (Exception ex) {
    		throw new SignException(ex);
		} 
    }
}
