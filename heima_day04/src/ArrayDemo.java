/*
定义数组容器
定义数组类型,要素,强制数据类型的语言
必须有数据类型,大小,就是存储数据的个数
定义数组公式:
数据类型[] 变量名=new 数据类型[存储元素的个数];
数据类型:数组中存储元素的数据类型
[] 标识数组的意思
变量名 自定义标识符

new 创建容器关键字
数据类型:数组中存储元素的数据类型
[] 表示数组的意思
元素个数,就是数组中,可以存储多少个数据.(恒定,定长)

栈中存放内存地址
堆中存放实际数据
同c#
但是和c# 不同的是,直接输出数组,不会同c#一样调用ToString()
而是会直接打印出内存地址

数组是一个容器,存储到数组中的元素,都有自己的自动编号
自动编号,最小值是0,最大值,长度-1
专业名词 索引index,下标,角标
访问数组存储的元素,必须依赖于索引,公式,数组名[索引]

会自动提供默认值

数组的属性length
同c#
数组的最小索引是0,最大索引数组.length-1
 */

public class ArrayDemo {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		// foreach(int c in a){
		// System.out.println(c);
		// }

		// 定义了数组容器,容器长度为3
		int[] arr = new int[3];
		System.out.println(arr[0]);
		System.out.println(arr.length);
	}
}