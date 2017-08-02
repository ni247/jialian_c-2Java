package cn.itcast.demo3;

/*
 *  JDK1.5新特性,静态导入
 *  目的是减少开发的代码量
 *  标准的写法,导入包的时候才能使用
 *  
 *  最末尾必须是一个静态成员
 */
import static java.lang.System.out;

public class StaticImportDemo {
public static void main(String[] args) {
	out.println("hello");
}
}
