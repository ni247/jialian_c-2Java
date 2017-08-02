/*
ASCII编码表演示
字符java 数据类型 char  占用2个字节
整数 数据类型int        占用4个字节

int类型和char数据类型转换,类型自动转换,char数据类型,会查询编码表,得到整数-char-int自动转换 int-char需要强制转换.
都会查询编码表

当char类型查询汉字时,会查询Unicode编码表.因为Unicode中会存储两个字节.
char可以和int进行计算.提升为int类型,因为在内存中是有两个字节.
char的取值范围是0-65535

short char 类型都是占用两个字节的内存
short取值范围-32768-32767
char取值范围 0-65535
short类型二进制最高位,是符号位.1是负数,0是正数
char类型二进制,全是数值,没有最高位符号位
 */
public class ASCIIDemo {
	public static void main(String[] args) {
		char c = 'a';
		int i = c + 1;
		System.out.println(i);

		int j = 6;
		char h = (char) j;
		System.out.println(h);
	}
}