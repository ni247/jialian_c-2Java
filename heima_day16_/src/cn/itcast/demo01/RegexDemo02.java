package cn.itcast.demo01;

public class RegexDemo02 {
	public static void main(String[] args) {
		String email1 = "123456@qq.com";
		String email2 = "mufy_fdsaf@sina.com";
		String email3 = "nin@163.com";
		String email4 = "wodof@yahoo.com.cn";
		System.out.println(checkEmial(email1));
		System.out.println(checkEmial(email2));
		System.out.println(checkEmial(email3));
		System.out.println(checkEmial(email4));
	}

	public static boolean checkEmial(String email) {
		return email.matches("[\\w]+@[0-9a-z]+(\\.[a-z]+)+");
	}
}
