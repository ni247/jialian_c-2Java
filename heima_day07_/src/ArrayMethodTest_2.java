/*
  数组的排序:一般都是升序排序,元素,小到大的排序
  
  两种排序的方式
  选择排序
  冒泡排序
  规则:比较大小,位置交换
  
  选择排序:数组中的每个元素,和其他元素进行比较换位置
 */
public class ArrayMethodTest_2 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 3, 4, 5, 6, 3 };
		selectSort(arr, false);
		printArr(arr);
	}

	/*
	 * 定义方法,实现数组的选择排序 返回值:没有 参数:数组 实现步骤: 1.嵌套循环实现排序 外循环,控制的是一共比较了多少次
	 * 内循环,控制的是一共比较了多少元素 2.判断元素的大小值 小指.存储到小的索引
	 * 
	 * 领悟:在开始前,先定义好内外循环控制的是什么.
	 */
	public static void selectSort(int[] arr, boolean isDesc) {
		int arrLength = arr.length;
		int temp;
		for (int i = 0; i < arrLength - 1; i++) {
			// 内循环,是每次都在减少,减少变量的定义
			for (int j = i + 1; j < arr.length; j++) {
				if (isDesc) {
					if (arr[i] < arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				} else {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
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
}