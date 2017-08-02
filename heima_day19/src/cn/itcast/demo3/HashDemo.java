package cn.itcast.demo3;

/*
 *  对象的哈希值,普通的10进制整数
 *  源自于父类Object hashCode方法
 */
public class HashDemo {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.hashCode());
		
		String s=new String("abc");
		System.out.println(s.hashCode());
	}
}
