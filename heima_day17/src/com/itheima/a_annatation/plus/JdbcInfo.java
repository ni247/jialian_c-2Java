package com.itheima.a_annatation.plus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JdbcInfo {
	String driverClass() default "com.mysql.jdbc.Driver";

	String url() ;

	String user() default "root";

	String password() default "1234";
}
