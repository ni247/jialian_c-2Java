package CustomAttr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import Enum.IdType;

@Target(ElementType.TYPE)
public @interface Id {
	public String Name();

	public IdType IdType();
}
