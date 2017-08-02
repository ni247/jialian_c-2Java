package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Map.Entry;
import java.util.Set;
import static Common.EmptyUtil.isNOtEmptyOrNull;;

/**
 * 网络工具类
 * @author Administrator
 *
 */
public final class WebUtils {
	public static final int TIMEOUT = 1000000;
	public static final String CHARSET = "utf-8";
	// url编码标记
	public static boolean ISURLENCODING = true;

	public String doPost(String url, IDictionary parameters) {
		return doPost(url, parameters, CHARSET, TIMEOUT);
	}

	public String doPost(String url, IDictionary parameters, String charset) {
		return doPost(url, parameters, charset, TIMEOUT);
	}

	public String doPost(String url, IDictionary parameters, String charset, int timeout) {
		PrintWriter out = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("contentType", "application/x-www-form-urlencoded;charset=" + charset);
			conn.setConnectTimeout(timeout);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 获取字符串类型参数
			String postData = buildQuery(parameters);
			// 发送请求参数
			out.print(postData);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			result = getResponseAsString(conn.getInputStream());
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public String getResponseAsString(InputStream inputstream) {
		StringBuilder result = new StringBuilder();
		String line;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(inputstream));
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {

		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	public static String buildQuery(IDictionary parameters, String charset, boolean isUrlEncoding)
			throws UnsupportedEncodingException {
		StringBuilder postData = new StringBuilder();
		Set<Entry<String, String>> entrySet = parameters.entrySet();
		// 遍历循环准备的参数
		String name;
		String value;
		String encodeValue;
		for (Entry<String, String> entry : entrySet) {
			name = entry.getKey();
			value = entry.getValue();
			if (isNOtEmptyOrNull(name) && isNOtEmptyOrNull(value)) {
				postData.append("&" + name);
				if (isUrlEncoding) {
					encodeValue = URLDecoder.decode(value, charset);
					postData.append(encodeValue);
				}
			}
		}
		return postData.toString();
	}

	public static String buildQuery(IDictionary parameters, String charset) throws UnsupportedEncodingException {
		return buildQuery(parameters, charset, ISURLENCODING);
	}

	public static String buildQuery(IDictionary parameters) throws UnsupportedEncodingException {
		return buildQuery(parameters, CHARSET, ISURLENCODING);
	}
}
