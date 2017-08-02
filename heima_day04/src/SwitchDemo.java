/*
  选择语句 Switch 语句
  编写格式 
  switch(表达式){
	  case 常量1:
	  要执行的语句;
	  break;
	  case 常量2:
	  要执行的语句;
	  break;
	  default:
	  要执行的语句;
	  break;
  } 
  需要特别注意的是switch 是小写开头的.s是小写
  java 自带的都是小写字母开头的.
  jdk1.0-1.4 数据类型接受 byte short int char
  jdk1.5 数据类型接受byte short int char enum(枚举)
  jdk1.7 数据类型接受byte short int char enum String 
  这边需要特别注意的是
  不能使用long类型的
  
  同c# 一样,也具有穿透性.因为没有break,程序会一直向下穿透
 */
public class SwitchDemo {
	public static void main(String[] args) {
		int j = 2;
		switch (j) {
		case 0:
			System.out.println(0);
			break;
		case 9:
			System.out.println("太神奇了");
			break;
		case 1:
		case 2:
		case 3:
			System.out.println("穿透了吗");
		default:
			break;
		}
	}
}