package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XpathDemo {
	public static void main(String[] args) throws Exception {
		// 加载dom树
		Document doc = new SAXReader().read(
				"D:\\CloudStation\\personal\\heima28\\day08\\xml\\web.xml");

		/*// 获取多节点
		List<Element> list = doc.selectNodes("/web-app/servlet/servlet-name");
		if (list.size() > 0) {
			Element ele = list.get(0);
			System.out.println(ele.getText());
		}*/

		Node ele = doc.selectSingleNode("/web-app/servlet/servlet-name");
		System.out.println(ele.getText());

	}
}
