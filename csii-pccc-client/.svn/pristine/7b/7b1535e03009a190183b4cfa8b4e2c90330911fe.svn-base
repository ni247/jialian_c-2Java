package com.csii.pccc.service;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.ResourceBundle;

/*import sun.misc.BASE64Encoder;*/



import com.csii.pccc.core.Base64;
import com.csii.pccc.core.KeyProvider;
//import com.csii.pccc.core.PlainUtil;
import com.csii.pccc.core.Signature;
import com.csii.pccc.util.Assert;
import com.csii.pe.common.security.DigitalSignatureUtil;
import com.sun.net.ssl.internal.ssl.Provider;

/**
 * 商户服务类
 *
 */
public class MerchantService {
	private static KeyStore keystore;
	private static String keystoreType = "JKS"/*"PKCS12"*/;
	private static ResourceBundle resourceBundle;
	private static final String signatureAlgorithm = "SHA1WithRSA";
	/*private static String signatureAlgorithm = "MD5withRSA";*/
	private static X509Certificate certificate;
	private static PrivateKey prikey = null;
	private static String charset = "utf-8";
	  
	static
	{
	    Security.addProvider(new Provider());
	    resourceBundle = ResourceBundle.getBundle("pccc_merchant");
	    keystoreType = resourceBundle.getString("mer.keystore.storeType");
	    String keystoreFilePath = resourceBundle.getString("mer.keystore.filePath");
	    String keystorePassword = resourceBundle.getString("mer.keystore.password");
	    keystore = KeyProvider.getInstance(keystoreType, keystoreFilePath, keystorePassword);
	    String certData = resourceBundle.getString("ibp.publickey.Data");
	    certificate = KeyProvider.getCert(certData);
	    
	    if ("PKCS12".equalsIgnoreCase(keystoreType)) {
	    	try {
	    		String privatekeyPassword = resourceBundle.getString("mer.key.password");
	    		Enumeration<String> keyAlias = keystore.aliases();
	    		String nextElement = null;
	    		while(keyAlias.hasMoreElements()){
	    			nextElement = keyAlias.nextElement();
	    			boolean keyEntryFlag = keystore.isKeyEntry(nextElement);
	    			if(keyEntryFlag) {
	    				prikey = (PrivateKey) keystore.getKey(nextElement, privatekeyPassword.toCharArray());
	    				break;
	    			}
	    		}
	    		
	    		if(prikey != null){
	    			System.out.println("私钥[别名：" + nextElement + "]成功获取！");
	    		}
	    	} catch (UnrecoverableKeyException e) {
	    		e.printStackTrace();
	    	} catch (KeyStoreException e) {
	    		e.printStackTrace();
	    	} catch (NoSuchAlgorithmException e) {
	    		e.printStackTrace();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    } else {
	    }
	    
	}
	
	/**
	 * 签名
	 * @param plain
	 * @return
	 */
	public static String sign(String plain) {
		Signature signature = new Signature();
		KeyProvider keyProvider = new KeyProvider(keystore);
		String alias = resourceBundle.getString("mer.keystore.alias");
		String privatekeyPassword = resourceBundle.getString("mer.key.password");
		PrivateKey privateKey = keyProvider.getPrivateKey(alias,privatekeyPassword);
		return signature.sign(plain, signatureAlgorithm, privateKey);
	}

	/**
	 * 验签
	 * @param plain
	 * @param signData
	 * @return
	 */
	public static boolean verify(String plain, String signData) {
		Signature signature = new Signature();
		Assert.notNull(certificate, "can't get the certificate of paygate.");
		return signature.verify(plain, signData,signatureAlgorithm,certificate.getPublicKey());
	}
	
	/**
	 * 加密
	 * @param signData
	 * @return
	 */
	public static String encrypt(String signData){
		Signature signature = new Signature();
		return signature.encryptByPublicKey(signData, certificate.getPublicKey());
	}
	
	/**
	 * 解密
	 * @param signData
	 * @return
	 */
	public static String decrypt(String encryptedData){
		Signature signature = new Signature();
		KeyProvider keyProvider = new KeyProvider(keystore);
		String alias = resourceBundle.getString("mer.keystore.alias");
		String privatekeyPassword = resourceBundle.getString("mer.key.password");
		PrivateKey privateKey = keyProvider.getPrivateKey(alias,privatekeyPassword);
		return signature.decryptByPrivateKey(encryptedData, privateKey);
	}
	
	/**
	 * 签名
	 * @param plain
	 * @return
	 */
	public static String getSignature(String plain) {	
		PrivateKey key = prikey;
		String signresult="";
		try {
			byte [] signature = DigitalSignatureUtil.sign(key, signatureAlgorithm, plain.getBytes(charset));
			/*BASE64Encoder encoder = new BASE64Encoder();
			signresult =  encoder.encode(signature);*/
			signresult = Base64.encodeAsString(signature);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signresult;
	}	
	
	/**
	 * 验签
	 * @param plain
	 * @param signData
	 * @return
	 */
	public static boolean verifySignature(String plain, String signData) {
		Signature signature = new Signature();
		Assert.notNull(certificate, "can't get the certificate of paygate.");
		return signature.verify(plain, signData, signatureAlgorithm, certificate, charset);
	}
	
	/**
	 * 示例（不适用浙江农信）
	 * @param args
	 */
	public static void main(String[] args) {
		/*Map data = new HashMap();
		data.put("TranAbbr", "IPER");
		data.put("MerchantDateTime", "20150802171600");
		data.put("OrderId", "0000000001");
		data.put("MerchantId", "00000000001");
		data.put("TermCode", "");
		data.put("TransAmount", "1.00");
		data.put("MerchantUrl", "后台商户通知地址");
		data.put("frontMerchantUrl", "前台商户通知地址");
		data.put("Remark1", "");
		data.put("Remark2", "");
		data.put("Subject", "");
		String plain = PlainUtil.parseMapToString(data);*/
		String plain = "<Finance><Message><TransName>WHDW</TransName><TransChannelId>04</TransChannelId><TransId>WHDW</TransId><MerchantId>010020150521152412</MerchantId><SubMerchantId>201506230000006545</SubMerchantId><UserNo></UserNo><MerSeqNo>0420151014103100</MerSeqNo><MerDateTime>20151012090000</MerDateTime><OrderId>0420151014103100</OrderId><TransAmt>1.00</TransAmt><Currency>01</Currency><MerURL>http://www.merurl.com</MerURL><MerURL1>http://www.merurl1.com</MerURL1><MsgExt>0420151012085901测试1</MsgExt></Message></Finance>";
		System.out.println("组装后的明文数据："+plain);
		String signData = MerchantService.sign(plain);
		System.out.println("签名后的数据："+signData);
		/*String encryptData = MerchantService.encrypt(plain);
		System.out.println("加密后的数据："+encryptData);
		String decryptData = MerchantService.decrypt(encryptData);
		System.out.println("解密后的数据："+decryptData);
		boolean verifyflag = MerchantService.verify(decryptData, signData);*/
		boolean verifyflag = MerchantService.verify(plain, signData);
		System.out.println("验签结果："+verifyflag);
		
	}
}
