package cn.incast.demo06;

/*
 *  构造方法第一行,写this() 还是super()
 *  不能同时存在,任选其一,保证子类的构造方法调用到父类的构造方法即可
 *  
 *  this 和super因为都要写第一行.
 *  所以.
 */
public class Student extends Person {
	public Student() {
		this(3);
	}

	public Student(int t) {
		super(3);
	}
}
