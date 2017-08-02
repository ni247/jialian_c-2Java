package cn.itcast.demo01;

/*
 * 定义研发部的员工
 * 属于员工中的一种
 * 
 * 关键字 extends
 * 
 * 子类重写父类的方法,保证子类方法的权限大于或者等于父类方法权限
 * 四大权限 public protected default private
 * 需要特别注意的是,default不能显示申明.申明的话编译或出错
 */
public class Developer extends Emolpyee {
	public int age;

	public static void main(String[] args) {
	}

}
