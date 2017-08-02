/*
数组的两个定义方式
数组类型[] 变量名=new 数据类型[]{元素1,元素2}
注意事项:new后面的[]中,不允许写任何内容,写了就编译失败
主要是规避风险,后面数量和[]中不通

第二种方式
数组类型[] 变量名={元素1,元素2};
直接大括号赋值
 */
public class ArrayDemo_2 {
	public static void main(String[] args) {
		// int[] arr=new int[]{1,2,3,4,5,6,7,8};
		int[] arr1 = { 1, 2, 3, 45 };
		for (int i = 0; i < arr1.length; i++)
			System.out.println(arr1[i]);
	}
}