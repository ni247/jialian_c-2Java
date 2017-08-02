package cn.itcast.demo1;


/*
 * jdk1.5后出现的特性,自动装箱和自动拆箱
 * 自动装箱:基本数据类型转换为对象(引用类型)
 * 自动拆箱:对象中的数据变回基本数据类型
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		function_2();
	}

	public static void function_2() {
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		System.out.println(i1 == i2); //==引用类型,比较的对象地址
		System.out.println(i1.equals(i2)); //equals 比较对象的数据
		System.out.println("========================");
		Integer j1 = 500;
		Integer j2 = 500;
		System.out.println(j1 == j2);
		System.out.println(j1.equals(j2));
		System.out.println("=========================");
		Integer aa = 127;
		Integer bb = 127;
		//true,数据在byte范围内,jvm不会从新new对象创建 .节约内存
		System.out.println(aa == bb);
		System.out.println(aa.equals(bb));
	}

	//自动装箱和拆箱弊端,可能出现空指针异常
	public static void function_1() {
		Integer in = null; //null是引用类型的公共值
		//		in = in + 1;
		System.out.println(in);
	}

	/*
	 *  自动装箱,拆箱的好处:基本类型和引用类直接运算
	 */
	public static void function() {
		//基本数据类型1,直接变成了对象
		Integer i = 1; //Integer i=new Integer(1);

		//后面i+1 ==> i.intValue()+1
		//前面的=又将基本数据类型转换了对象
		i = i + 1;
	}
}
