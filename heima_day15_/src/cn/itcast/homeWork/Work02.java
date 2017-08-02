package cn.itcast.homeWork;

public class Work02 {
	public static void main(String[] args) {
		String[] str = { "101", "203", "4047", "4040", "4004" };
		get(str);
	}

	public static void get(String[] arrStr) {
		if (arrStr == null)
			return;
		String str;
		//		int dcCount = 0;
		int strLength;
		for (int i = 0; i < arrStr.length; i++) {
			str = arrStr[i];
			strLength = str.length();
			for (int j = 0; j <= strLength / 2; j++) {

				if (str.charAt(j) != str.charAt(strLength - j - 1)) {
					System.out.println(str + "不对称");
					break;
				}
				if (j == strLength / 2) {
					System.out.println(str + "对称");
					//					dcCount++;
				}
			}
		}
	}
}
