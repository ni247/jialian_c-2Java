package cn.itcast.interfaces;

/*
 *  必须使用实现类才能使用
 */
public class TestArguments {
	public static void main(String[] args) {
		new Smoking() {

			@Override
			public void smoking() {
				System.out.println("抽不抽烟");
			}
		}.smoking();
	}

	/**
	 * 这块为什么可以使用接口,抽象类当做参数,返回值.主要是因为接口,抽象类不能new.返回的,或者当参数的.都是继承,实现 该抽象类,或者接口的类
	 * 
	 * @param s
	 */
	public static void noSmoking(Smoking s) {
		s.smoking();
	}
}
