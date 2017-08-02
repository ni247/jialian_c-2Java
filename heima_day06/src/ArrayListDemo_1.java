/*
ArrayList集合中的方法
bool  add(object data)  向你的集合中添加元素
get(int index) 取出集合中的元素,get方法的参数,写入索引
size() 返回集合的长度,集合存储元素的个数

 */
import java.util.ArrayList;

public class ArrayListDemo_1 {
	public static void main(String[] args) {
		// 定义集合.存储字符串元素
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		array.add("abc");
		array1.add(1);
		int size = array.size();
		String s = array.get(0);
		// 输出集合的长度,调用集合方法size,size方法的返回值类型int
		System.out.println(size);
		System.out.println(s);
	}
}