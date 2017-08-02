/*
ArrayList 集合的使用
也是引用数据类型
步骤:
1.导入包 java.util包中
2.创建引用类型的变量
ArrayList<集合存储的数据类型> 变量名=new 数据类型<集合存储的数据类型> ();
集合存储的数据类型:要将数据存储到集合的容器中
创建集合引用变量的时候,必须要制定好,存储的类型是多少
ArrayList<String> array=new ArrayList<String>();
3.变量名.方法 调用方法

长度可变的一个数组
集合要存储元素的数据类型中的数据类型必须是引用数据类型,不能是基本类型(值类型)
8中基本类型所对应的引用数据类型标识形式:
byte Byte
short Short
int  Integer
long Long
float Float
double Double
 */
import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		// 创建集合容器,指定存储的数据类型
		// 存储字符串
		ArrayList<String> array = new ArrayList<String>();
		// 存储整型
		// ArrayList<Integer> arrInt = new ArrayList<Integer>();
		array.add("54");
	}
}