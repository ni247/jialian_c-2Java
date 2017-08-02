/*
 数据类型的自动转换
 自动转换:取值范围小的类型,自动转成取值范围大的类型

 */
public class DataConvert {
	public static void main(String[] args) {
		double d = 1000; // int直接转换成了double类型
		System.out.println(d);

		int i = 100;
		double d2 = i;
		System.out.println(d2);

		// boolean不参与自动转换
	}

}