package cn.itcast.demo2;

/*
 *  Throwable类中的方法
 *  三个方法,都和异常的信息有关系
 *     String getMessage()  对异常信息的简短描述
 *     String toString()    对异常信息的详细描述
 *     void printStackTrace()  将异常信息追踪到标准流(控制台),异常信息最全.jvm默认调用方法也是这个方法
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		try {
			function();
		} catch (Exception e) {
			// TODO: handle exception
			//			System.out.println(e.getMessage());
			//			System.out.println(e);
			e.printStackTrace();
		}
	}

	static void function() throws Exception {
		throw new Exception("异常了");
	}
}
