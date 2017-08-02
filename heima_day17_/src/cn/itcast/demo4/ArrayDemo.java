package cn.itcast.demo4;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		function_2();
	}

	/*
	 *  static String toString(数组)
	 *  将数组变成字符串
	 */
	public static void function_2() {
		int[] arr = { 1, 3, 7, 8, 11, 15 };
		String s = Arrays.toString(arr);
		System.out.println(s);
	}

	/*
	 * static int binarySearch(数组,被查找的元素)
	 * 数组的二分搜索法
	 * 返回元素在数组中出现的索引
	 * 需要注意的是,如果没找到,返回的是(-插入点-1)
	 */
	public static void function_1() {
		int[] arr = { 1, 3, 7, 8, 11, 15 };
		int index = Arrays.binarySearch(arr, 6);
		System.out.println(index);

	}

	public static void function() {
		int[] arr = { 5, 1, 4, 6, 8, 9, 0 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			System.out.println(j);
		}
	}
}
