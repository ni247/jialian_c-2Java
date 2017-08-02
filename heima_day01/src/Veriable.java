/*
定义java中的变量 
定义出所有数据类型的变量
四类八种
 */
public class Veriable {
	public static void main(String[] args) {
		// 定义整数类型,字节类型,byte
		byte b1 = 121;
		System.out.println(b1);

		// 定义整数类型,短整数,short类型
		short s1 = 121;
		System.out.println(s1);

		// 定义整数类型,整数,int类型
		int i1 = 121;
		System.out.println(i1);

		// 定义整数类型,长整型,long类型
		long l1 = 121L;
		System.out.println(l1);

		// 定义浮点型类型,单精度浮点类型,float类型
		float f1 = 100F;
		System.out.println(f1);

		// 定义浮点型类型,双进度浮点类型,double类型
		// double d2 = 100.0D;
		double d1 = 100.0; // 可以加D,默认就是D.
		System.out.println(d1);

		// 定义char类型,内存中2个字节,必须单引号包裹.只能写1个字符
		char c1 = 'a';
		System.out.println(c1);

		// 定义布尔类型
		boolean b2 = true;
		System.out.println(b2);
	}
}