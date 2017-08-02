/*
定义方法,遍历数组的遍历
输出结果[11,33,44]
注意数组的传值.int[] 而不是Array
注意方法的优化,这样比之前快很多.
 */
public class ArrayMethodTest {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 76 };
		printArr(a);
		printArr(a);
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