package com.csii.pccc.service;

/**
 * 外接电商签名延签示例代码
 * 浙江省农信商户接入
 * @author fansonggu@csii.com.cn
 *
 */
public class MockMerchantTest {

	public static void main(String[] args) {
		//待签名数据为 xml 格式报文，报文格式如下所示：
	//	String plain = "<Finance><Message><TransId>PSNR</TransId><MerchantId>201609100000417</MerchantId><MerSeqNo>Test20161111170348</MerSeqNo><MerDateTime>20161111171848</MerDateTime><TransSeqNo>201611110000103121</TransSeqNo><ClearDate>20190501</ClearDate><TransAmt>1.00</TransAmt><RespCode>000000</RespCode><Remark1>remark1</Remark1><Remark2>remark2</Remark2><MerTransList></MerTransList></Message><Signature>qptc2k8dYGdPCjSFm2U5z4YG1nWqDLZJJVuFKw+bISn6zN2hlkSAbTFh2P0w9BEKkWuXO3R9+a8R8WybywMu2xnHZvmV0LZWbWPxbBWaXRnB4l6sjRi6lpfk/Znva1N6tgiObm4sHHZ8kfFBviWkXjmqI5u2PTbdZAmeWiDwAEcZa75M99OGg2K6neUkovY8B/vTOfH8p2RfoAihg3ZJJz1HnhL2j8PnIIWa5kcoAPDKCP+wqEVBHoVLGWRNk89S++X1gTLliqLKcc8LG35UbdLf24AxZrpYqP/SdNaUthP2PSuG/D9Omu70PiUh383CZvrOZGc2hC52NizNSkd0zg==</Signature></Finance>";
		String plain = "123";
		System.out.println("组装后的明文数据："+plain);  // 组装请求报文时，将此字符串放置在 Plain 域上
		
		String signData = MerchantService.getSignature(plain); // 发送浙江农信前，对报文签名
		System.out.println("签名后的数据："+signData); // 组装请求报文时，将此字符串放置在 Signature 域上
		
		boolean verifyflag = MerchantService.verifySignature(plain, signData); // 浙江农信返回报文后，需对浙江农信返回的报文进行验证签名操作，只有验证签名结果为true的交易才是正常交易，否则应该报签名异常的错误
		System.out.println("验签结果："+verifyflag);
	}

}
