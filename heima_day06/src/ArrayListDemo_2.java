/*
  集合的遍历
  实现思想也是索引思想
  集合的索引从0开始,到size()-1
  方法 get(int index)
 */
import java.util.ArrayList;

public class ArrayListDemo_2 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);

		// 对集合进行遍历
		// 使用方法 size+get组合进行遍历
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}