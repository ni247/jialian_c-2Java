package cn.itcast.demo02;

/*
 * StringBuffer字符串的缓冲区对象,提高字符串的操作效率
 * 内部采用了可变数组方式实现,类内部定义了数组,这个数组没有final
 * 
 */
public class StringTest {
	public static void main(String[] args) {
		getCount("abcD12355ABCCCC");
		getNewStr("aBASDASFASDF");
		System.out.println(getContainsCount("helloworld,wodeworld,dayeworld",
				"world"));
		//		StringBuffer sb = new StringBuffer();
	}

	/*
	 *  获取指定字符串中,大写字母,小写字母,数字的个数
	 *  思想:
	 *  1.计数器,就是int变量,满足条件++
	 *  2.遍历字符串,长度方法length()+charAt 遍历
	 *  3.字符判断是大写,是小写,还是数组
	 */
	public static void getCount(String s) {
		//定义三个变量,计数
		int upperCount = 0;
		int lowerCount = 0;
		int numCount = 0;
		int temp;
		if (s == null)
			return;
		for (int i = 0; i < s.length(); i++) {
			//这边会自动提升.char-隐式转换为int
			temp = (s.charAt(i));
			if (temp >= 65 && temp <= 90)
				upperCount++;
			else if (temp >= 97 && temp <= 122)
				lowerCount++;
			else if (temp >= 48 && temp <= 57)
				numCount++;
		}
		System.out.println("字符串" + s + "总共大写字母" + upperCount + "个,小写字母"
				+ lowerCount + "个,数字" + numCount + "个");
	}

	public static void getNewStr(String str) {
		if (str == null)
			return;
		String start = str.substring(0, 1).toUpperCase();
		String end = str.substring(1).toLowerCase();
		System.out.println(start + end);
	}

	public static int getContainsCount(String str, String key) {
		int count = 0;
		int index = 0;
		if (str == null)
			return count;
		//需要注意的是index必须加1位,不然从找到的位置在找数据.会返回找到第一个
		for (int i = 0; i < str.length(); i++) {
			index = str.indexOf(key, index) + key.length();
			if (index == -1 + key.length())
				break;
			else
				count++;
		}
		return count;
	}

	public static int getContainsCount2(String str, String key) {
		int count = 0;
		int index = 0;
		if (str == null)
			return count;
		//需要注意的是index必须加1位,不然从找到的位置在找数据.会返回找到第一个
		while ((index = str.indexOf(key)) != -1) {
			count++;
			str = str.substring(index + key.length());
		}
		return count;
	}
}
