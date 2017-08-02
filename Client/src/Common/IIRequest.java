package Common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.sun.istack.internal.NotNull;
import com.sun.net.httpserver.HttpContext;

/**
 * request请求基类
 * 
 * @author Administrator
 * @param <T>
 *
 */
public class IIRequest<T> extends IRequest<T> implements Serializable {

	public boolean initRequest() throws InstantiationException, IllegalAccessException {
		Class<T> entityClass = null;
		Type t = getClass().getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<T>) p[0];
		}
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			NotNull annotation = field.getAnnotation(NotNull.class);
			// if(annotation!=null&&config.getServletContext();)
		}
		return true;
	}

}
