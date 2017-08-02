package cn.itcast.demo3;

/*
 *  需要注意的是int无法强制转换为toString
 *  
 *   需要注意的是java的泛型是伪泛型,因为编译成功后的class文件中其实是没有泛型的.具体到了哪个类.
 *   这样也是成功的,因为类型不通,编译不会成功
 */
public class GenericDemo {
	public static void main(String[] args) {
		int i = 5;
		String s = String.valueOf(i);
		System.out.println(s);
	}
}
