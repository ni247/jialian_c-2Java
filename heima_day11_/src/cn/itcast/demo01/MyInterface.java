package cn.itcast.demo01;

/* 这里面包名使用...是有作用的.
 * 文件夹cn 西面 itcast文件夹 demo01文件夹
 * 所写的java文件就在cn/itcast/demo01中
 * 
 * 接口关键词 interface 同c#
 * 
 * 注意,接口文件编译完了还是为class后缀
 * 
 * 接口定义:
 * 成员方法,全部抽象
 * 不能定义带有方法体的方法
 * 
 * 定义抽象方法:固定格式
 * public abstract 返回值类型 方法名称(参数列表)
 * 为什么? 接口必须让人继承(本身没有实现),
 * abstract接口必须是抽象的.本省就是让人实现的.只是声明这个东西
 * 
 * 关于接口的修饰符,可以不写,不写就是默认public,写了还是public
 * 建议还是写上public
 * 
 * 接口成员变量的定义
 * 变量成员的定义,具体要求
 * 
 * 要求:必须定义为常量
 * 固定格式:
 * public static final 数据类型 变量名=值
 * 可以缩写为数据类型 变量名=值(默认)
 * 
 * 这里的final就是最终的.不允许值修改.
 * 
 * 需要注意到是接口中的方法必须是抽象方法
 * 接口中的成员变量必须是静态常量(无法实例接口)
 * public static final int d=3;
 */
public interface MyInterface {
	int a = 3;
	public static final int aa = 5;

	// 这里的第一句等同于第二句
	public abstract void function();

	abstract void getSum();
	// 上面两句等同
}
