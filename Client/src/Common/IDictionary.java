package Common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 符合aop(面向切面编程)习惯的纯字符串字典结构
 * @author Administrator
 *
 */
public class IDictionary extends Hashtable<String, String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8944930464845649970L;
	private final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public IDictionary() {
	}

	public void add(String key, Object value) {
		String strValue;
		if (value == null)
			strValue = null;
		else if (value instanceof String)
			strValue = (String) value;
		else if (value instanceof Date) {
			Date date = (Date) value;
			SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
			strValue = df.format(date);
		} else if (value instanceof Integer)
			strValue = ((Integer) value).toString();
		else if (value instanceof Long)
			strValue = ((Long) value).toString();
		else if (value instanceof Double)
			strValue = ((Double) value).toString();
		else if (value instanceof Boolean)
			strValue = ((Boolean) value).toString();
		else
			strValue = value.toString();
		this.put(key, strValue);
	}

	public synchronized String put(String key, String value) {
		if (EmptyUtil.isNOtEmptyOrNull(key) && EmptyUtil.isNOtEmptyOrNull(value))
			super.put(key, value);
		return value;
	}

}
