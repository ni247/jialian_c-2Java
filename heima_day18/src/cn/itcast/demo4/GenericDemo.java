package cn.itcast.demo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 *  泛型的通配符 ?
 *  
 */
public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(3);
		a.add(5);
		HashSet<String> b = new HashSet<>();
		b.add("6");
		b.add("8");
		iterator(a);
		iterator(b);
	}

	/*
	 *  使用HashSet和ArrayList的父类(超类),中间放java通配符?
	 *  来作为形参.不过需要注意的是,不能强制转换.也就不能使用原本类独特的成员
	 */
	public static void iterator(Collection<?> c) {
		Iterator<?> iter = c.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
