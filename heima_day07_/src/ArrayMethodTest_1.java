/*
数组的指针思想:就是数组的索引
指针是可以随时指向数组的任意的一个索引
需要两个指针
一个叫大指针,小指针
大指针=最大索引
小索引=0索引

翻转reverse
实现步骤:
1.定义方法,实现数组的逆序
2.遍历数组
实现数组的最远索引换位置
使用临时的第三方变量

这里需要注意的是.因为数组是引用类型,所以在方法中改变了.会直接音响大气值
for循环的第一项,第三项可以定义多个变量,用,隔开
 */
public class ArrayMethodTest_1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		reverseAndPrint(arr);
		reverseAndPrint(arr1);
	}

	public static void arrayReverse(int[] arr) {
		int temp;
		int arrLength = arr.length;
		for (int i = 0; i < arrLength / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arrLength - 1 - i];
			arr[arrLength - 1 - i] = temp;
		}
	}

	public static void printArr(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1)
				System.out.print(arr[i] + ",");
			else
				System.out.println(arr[i] + "]");
		}
	}

	public static void reverseAndPrint(int[] arr) {
		arrayReverse(arr);
		printArr(arr);
	}
}
