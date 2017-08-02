package cn.itcast.demo04;

/*
 * 定义好的智能手机类
 * 功能:打电话,发短信
 * 来电显示:号码,姓名,大头像
 * 直接使用原先手机上的打电话和发短信功能
 * 新的功能添加上姓名和大头像
 * 
 * 新的手机,继承原先的手机,直接使用Phone类的打电话和发短信功能
 * 但是:将原来的来电功能,进行重写,加入新内容
 * 
 * 
 */
public class AndriodPhone extends Phone {
	public void showNum() {
		// 父类中的方法showNum已经可以显示号码了.子类可以直接用
		super.showNum();
		System.out.println("显示姓名");
		System.out.println("显示大头像");
	}
}
