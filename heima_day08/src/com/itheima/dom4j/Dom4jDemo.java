package com.itheima.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jDemo {
	public static void main(String[] args) throws Exception {
		// 创建核心对象
		SAXReader reader = new SAXReader();

		// 获取dom树
		// 记住不能有中文
		Document doc = reader.read("D:\\CloudStation\\personal\\heima28\\day08\\xml\\web.xml");

		// 获取根节点
		Element root = doc.getRootElement();
		// 获取其他按节点
		List<?> list = root.elements();
		for (Object elee : list) {
			Element ele = (Element) elee;
			System.out.println(ele.elementText("servlet-name"));
		}
		System.out.println(root.attributeValue("version"));
	}
}
