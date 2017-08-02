package cn.itcast.homeWork;

public class Work01 {
	public static void main(String[] args) {
		String str = "  abcdefg  ";
		System.out.println(isEmptyDemo(str));
		System.out.println(charAt(str, 5));
		System.out.println(toUpper(str));
		System.out.println(toLower(str));
		System.out.println(repalce(str, 'c', '3'));
		System.out.println(repalace(str, "c", "3"));
		System.out.println(trim(str));
	}

	public static boolean isEmptyDemo(String str) {
		return str.isEmpty();
	}

	public static char charAt(String str, int index) {
		return str.charAt(index);
	}

	public static String toUpper(String str) {
		return str.toUpperCase();
	}

	public static String toLower(String str) {
		return str.toLowerCase();
	}

	public static String repalce(String str, char oldChar, char newChar) {
		return str.replace(oldChar, newChar);
	}

	public static String repalace(String str, String oldStr, String newStr) {
		return str.replace(oldStr, newStr);
	}

	public static String trim(String str) {
		return str.trim();
	}

}
