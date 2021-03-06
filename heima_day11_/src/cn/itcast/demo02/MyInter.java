package cn.itcast.demo02;

/*
 *  接口中成员的特点
 *  1.成员变量的特点,没有变量,都是常量
 *  固定定义格式:
 *  public static final 变量类型 变量名=变量值
 *  可以缩写为 
 *  变量类型 变量名=变量值
 *  
 *  2.成员方法的特点,抽象的,公共的,没有方法体{} 直接已封号结束
 *  固定定义格式:
 *  public abstract 返回值 方法名(参数类型 参数变量,...);
 *  可以缩写为
 *  返回值 方法名(参数类型 参数变量,...);
 *  
 *  注意,几个修饰符可以选择性写,也可以不写
 *  代码编译后都会有的
 *  
 *  3.实现类,实现接口,必须实现接口全部抽象方法(同抽象类)
 *  如果不实现接口的全部方法,则子类是一个抽象类.同类
 *  
 *  接口的多实现,没有安全隐患.
 *  因为接口中的方法全是抽象,没有主题
 *  这块和c# 相同.类是单继承,接口是多实现
 *  
 *  那么问题来了,抽象类可以多继承吗
 *  
 */
public interface MyInter {
	public static final int a = 3;
	int b = 4;

	void function();
}
