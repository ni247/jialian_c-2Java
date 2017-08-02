package cn.itcast.demo09;

/*
 *  导包必须到最里面. 包就是命名空间的概念
 *  
 *  
 *  public 哪里都可以使用
 *  protected 本包,子类里面能调用.
 *  default 限于本包内可以使用
 *  private 就只能自己类中能使用
 */
public class Test {
	public static void main(String[] args) {
		// Lock lock = null;
		// cn.itcast.demo09
		/*
		 * 使用匿名内部类
		 * 
		 * 定义实现类,重写方法,创建实现类对象,一部到位
		 * 
		 * 格式 new 接口或者父类(){ 重写抽象方法 }
		 * 
		 * 从new开始到封号结束. 创建了接口的实现类的对象
		 * 
		 * soga
		 * 
		 * 能简化就尽量简化写
		 */
		Smoking s = new Smoking() {

			@Override
			public void smoking() {
				System.out.println("吸烟喽");
			}
		}; // 这里注意封号
		s.smoking();

		new Smoking() {

			@Override
			public void smoking() {
				System.out.println("吸烟喽");
			}
		}.smoking(); // 这里注意封号
	}
}
