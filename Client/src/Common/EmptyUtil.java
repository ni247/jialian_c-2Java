package Common;

import java.util.List;

/**
 * 判断对象是否为空
 * @author Administrator
 *
 */
public class EmptyUtil {
	public static boolean isEmptyOrNull(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof List)
			return ((List) obj).size() == 0;
		if (obj instanceof String)
			return ((String) obj).trim().equals("");
		return false;
	}

	public static boolean isNOtEmptyOrNull(Object obj) {
		return !isEmptyOrNull(obj);
	}
}
