/*
   集合ArrayList方法的补充
   add(int index,存储的元素)  将元素添加到指定的索引上 ,原本在该索引上的元素往后顺延
   set(int index,存储的元素)  修改指定索引的元素
   remove(int index) 删除指定索引上的元素
   clear() 清空集合中的所有元素
 */
import java.util.ArrayList;

public class ArrayListDemo_3 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(0, 2);
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.size());
		arr.set(0, 5);
		System.out.println(arr.get(0));
		arr.remove(0);
		System.out.println(arr.get(0));
	}
}