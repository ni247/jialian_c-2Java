package com.csii.pccc.core;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 *
 * 明文处理工具类
 * 
 * @version 1.0
 * 
 */

public class PlainUtil {

	private PlainUtil() {
		// do nothing
	}

	public static Map parseStringToMap(String data) {
		return parseStringToMap(data, "|");
	}

	public static String parseMapToString(Map data) {
		return parseMapToString(data, "|");
	}

	public static Map parseStringToMapNoDecode(String data) {
		return parseStringToMapNoDecode(data, "|");
	}

	public static String parseMapToStringNoEncode(Map data) {
		return parseMapToStringNoEncode(data, "|");
	}

	public static boolean checkPlain(String plain, Map checked) {
		Map data = parseStringToMap(plain);
		if (data == null) {
			return false;
		}

		return checkPlain(data, checked);
	}

	public static boolean checkPlain(Map plain, Map checked) {
		Iterator keys = checked.keySet().iterator();
		Object name = null;
		Object value = null;
		Object value1 = null;

		while (keys.hasNext()) {
			name = keys.next();
			value = checked.get(name);
			if (value == null) {
				continue;
			}
			if (!value.equals(value1)) {
				return false;
			}
		}

		return true;
	}

	public static Map parseStringToMap(String data, String token) {
		String PROPERTY_DELIMER = "=";
		String name = null;
		String value = null;
		int pos = 0;

		if (data == null)
			return null;

		StringTokenizer tokenizer = new StringTokenizer(data, token);
		Map props = new HashMap();

		if (tokenizer.countTokens() == 0) {
			throw new NoSuchElementException("");
		}

		while (tokenizer.hasMoreTokens()) {
			String element = tokenizer.nextToken();

			pos = element.indexOf(PROPERTY_DELIMER);
			if (pos != -1) {
				name = element.substring(0, pos);
				value = element.substring(pos + 1);
				if (name.startsWith("MerchantUrl")) {
					name = URLDecoder.decode(name);
					value = URLDecoder.decode(value);
				}
				props.put(name, value);
			}
		}
		return props;
	}

	public static String parseMapToString(Map data, String token) {
		String PROPERTY_DELIMER = "=";
		StringBuffer sb = new StringBuffer();
		String name = null;
		String value = null;
		boolean first = true;
		if (data == null)
			return null;

		Iterator keys = data.keySet().iterator();

		while (keys.hasNext()) {
			name = (String) keys.next();
			value = (String) data.get(name);
			if (value == null) {
				value = "";
			}
			if (first) {
				first = false;
			} else {
				sb.append(token);
			}

			if (name.startsWith("MerchantUrl")) {
				name = URLDecoder.decode(name);
				value = URLDecoder.decode(value);
			}
			sb.append(name);
			sb.append(PROPERTY_DELIMER);
			sb.append(value);
		}
		return sb.toString();
	}

	public static Map parseStringToMapNoDecode(String data, String token) {
		String PROPERTY_DELIMER = "=";
		String name = null;
		String value = null;
		int pos = 0;

		if (data == null)
			return null;

		StringTokenizer tokenizer = new StringTokenizer(data, token);
		Map props = new HashMap();

		if (tokenizer.countTokens() == 0) {
			throw new NoSuchElementException("");
		}

		while (tokenizer.hasMoreTokens()) {
			String element = tokenizer.nextToken();

			pos = element.indexOf(PROPERTY_DELIMER);
			if (pos != -1) {
				name = element.substring(0, pos);
				value = element.substring(pos + 1);
				props.put(name, value);
			}
		}
		return props;
	}

	public static String parseMapToStringNoEncode(Map data, String token) {
		String PROPERTY_DELIMER = "=";
		StringBuffer sb = new StringBuffer();
		String name = null;
		String value = null;
		boolean first = true;
		if (data == null)
			return null;

		Iterator keys = data.keySet().iterator();

		while (keys.hasNext()) {
			name = (String) keys.next();
			value = (String) data.get(name);
			if (value == null) {
				value = "";
			}
			if (first) {
				first = false;
			} else {
				sb.append(token);
			}

			sb.append(name);
			sb.append(PROPERTY_DELIMER);
			sb.append(value);
		}
		return sb.toString();
	}

	/***
	 * 
	 * 将Map顺序的转化为字符串。
	 * 
	 * @param data
	 * @param token
	 * @param datamap
	 *            顺序数组
	 * @return
	 */
	public static String parseMapToStringNoEncodeWithOrder(Map data, String token, String[] datamap) {
		String PROPERTY_DELIMER = "=";
		StringBuffer sb = new StringBuffer();
		String name = null;
		String value = null;
		boolean first = true;
		if (data == null)
			return null;

		for (int i = 0; i < datamap.length; i++) {
			name = datamap[i];
			value = (String) data.get(datamap[i]);
			if (value == null) {
				value = "";
			}
			if (first) {
				first = false;
			} else {
				sb.append(token);
			}

			sb.append(name);
			sb.append(PROPERTY_DELIMER);
			sb.append(value);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		Map kd = new HashMap();
		kd.put("a", "1");
		kd.put("b", "2");
		kd.put("c", "3");
		kd.put("d", "4");

		String st = PlainUtil.parseMapToStringNoEncodeWithOrder(kd, "|", new String[] { "a", "b", "c", "d" });

		System.out.println("st:" + st);

	}

}