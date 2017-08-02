public class MethodDemo_2 {
	public static void main(String[] args) {
		String s = "ccc";
		setString(s);
		System.out.println(s);
		int[] arr = { 1, 2, 3 };
		setArray(arr);
		System.out.println(arr[2]);
	}

	public static void setString(String str) {
		str += "5555";
	}

	public static void setArray(int[] arr) {
		arr[2] = 100;
	}
}