package cn.itcast.demo01;

/*
 *  实现正则规则和字符串进行匹配.使用字符串类的方法
 *  String类3个和正则表达式相关的方法
 *  boolean matches(String 正则规则)
 *  例子"abc".matches("[a]");
 *  作用:匹配字符串.匹配成功返回true
 *  
 *  String[] split(String 正则规则) (同c# 不同)
 *  "abc".split("a") 使用规则将字符串进行切割
 *  结果 String[] s={"a","bc"}
 *  
 *  String replaceAll(String 正则规则,String 字符串)
 *  按照正则规则,替换字符串
 *  "abc123".replaceAll("[\\d]","#")
 *  输出abc###
 */
public class RegexDemo {
	public static void main(String[] args) {
		//		System.out.println("abc123".replaceAll("[\\d]", "#"));
		System.out.println(checkIsOk("1111111111"));
		System.out.println(checkPhone("18367168666"));
	}

	/*
	 * 检查qq号码是否合法
	 * 0不能开头,全数字,位数5-10位
	 */
	public static boolean checkIsOk(String qq) {
		return qq.matches("[1-9][\\d]{4,9}");
	}

	/*
	 * 匹配手机号码
	 */
	public static boolean checkPhone(String no) {
		return no.matches("1[34578][\\d]{9}");
	}
}
