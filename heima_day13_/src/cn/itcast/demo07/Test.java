package cn.itcast.demo07;

public class Test {
public static void main(String[] args) {
	Outer.Inner i=new Outer().new Inner();
	i.show();
}
}
