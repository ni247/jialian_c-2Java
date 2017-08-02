package cn.itcast.demo03;

/*
 *   int[] arr={34,12,89,68} 将一个int[]中元素转成字符串
 *   格式[34,12,89,68]
 *   
 *   备注:这里因为是单线程操作,所以不需要考虑线程安全问题.
 *   所以推荐使用StringBuilder
 */
public class StringBufferTest {
	public static void main(String[] args) {
		//小知识点:在一维数组中,可以将[] 放在变量名后面
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(convertStr(arr));
	}

	public static String convertStr(int[] arr) {
		if (arr == null)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ",");
		}
		return (sb.delete(sb.length() - 1, sb.length()).append("]")).toString();
	}
}
