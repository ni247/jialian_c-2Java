package cn.itcast.demo2;

/*
 *  在继承后,在子类重写父类方法的时候,异常处理
 *  结论:
 *  父类的方法,如果抛出异常,子类重写后
 *  可以不抛出异常,
 *  也可以抛出,但抛出的异常不能大于父类的异常.(继承关系)
 *  
 *  父类抛出异常,子类可以不抛
 *  但是子类的抛出的异常只能等于或者小于父类的异常(继承关系)
 *  
 *  如果父类的方法没有抛出异常,子类重写也不能抛出异常
 *  
 *  结论:父类抛异常,子类可抛可不抛.抛了则必须等于该子类或者级别比父类小
 *  父类不抛,子类必须不抛
 *  
 *  如果子类中调用了抛出异常的方法,只能使用try-catch
 */
public class ExceptionDemo {

}

class Fu {
	public void function() throws RuntimeException {

	}

	public void function_1() {

	}
}

class Zi extends Fu {
	public void function() throws RuntimeException {

	}

	public void function_1() {

	}
}