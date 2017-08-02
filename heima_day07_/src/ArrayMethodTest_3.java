public class ArrayMethodTest_3 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 7 };
		// selectSort(arr,false);
		int index = binarySearch(arr, 9);
		System.out.println(index);
	}

	/*
	 * 定义方法,实现,折半查找 返回值:索引 参数:数组,被找的元素 实现步骤: 1.需要的变量定义 三个指针 2.进行循环折半 可以折半的条件
	 * min<max 3.让被找元素,和中间索引元素进行比较 元素>中间索引 小指针=中间+1 元素<中间索引 大指针=中间-1 元素==中间索引 找到
	 * 4.循环结束, 没有找到,返回-1
	 */
	public static int binarySearch(int[] arr, int key) {
		// 定义3个指针变量
		int min = 0;
		int max = arr.length - 1;
		int mid = 0;
		// 循环折半.条件 min<=max
		while (min <= max) {
			// 找中间索引
			mid = (min + max) / 2;
			// 让被找元素,和中间索引元素进行比较
			if (key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;
			else
				return mid;
		}
		return -1;
	}

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

}