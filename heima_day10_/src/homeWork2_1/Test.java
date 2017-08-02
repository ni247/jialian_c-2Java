package homeWork2_1;
/*
 * 接口是功能的集合,同样可以看成是一种数据类型,是比抽象类更为抽象的类
 * 接口只描述所应该所具备的方法,并没有具体实现,同抽象类
 * 这样的功能设计,将功能的定义与实现分离,优化了程序设计
 * 一切事物均有功能,即一切事物均有接口
 */
public class Test {
	public static void main(String[] args) {
		BasicTeacher b = new BasicTeacher();
		b.Teach();
		WorkTeacher w = new WorkTeacher();
		w.Teach();
	}
}
