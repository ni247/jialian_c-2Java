package com.itheima.example1;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Demo {
	@Test
	public void f1() throws Exception {
		// 解析xml文件
		// 创建document对象
		// 通过xpath解析获取servlet-class和
		Document doc = new SAXReader().read(
				"D:\\CloudStation\\personal\\heima28\\day08\\xml\\web.xml");
		Element serClass = (Element) doc
				.selectSingleNode("/web-app/servlet/servlet-class");
		Element serUrl = (Element) doc
				.selectSingleNode("/web-app/servlet-mapping/url-pattern");
		String servelet = serClass.getText();
		String url = serUrl.getText();
		System.out.println(servelet);
		System.out.println(url);
		Map<String, String> m = new HashMap<>();
		m.put(servelet, url);
	}
}
