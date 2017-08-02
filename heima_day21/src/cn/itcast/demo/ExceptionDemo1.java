package cn.itcast.demo;

/*
 *  异常的处理方式:
 *    try...catch...finally
 *    格式
 *    try{
 *    可能出现异常的代码
 *    }catch(异常类 变量名){
 *    异常的处理方式
 *    }finally{
 *    必须要执行的代码
 *    }
 *    
 *    允许多catch补货
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		/*	int[] arr = {};
			int i = getArray(arr);
			System.out.println(i);
			System.out.println("Game Over");*/

		try {
			int i = getArray(null);
			System.out.println(i);
		} catch (NullPointerException ex) {
			System.out.println(ex);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
	}

	/*
	 *  定义方法,抛出异常.
	 *  调用者使用try catch
	 */
	static int getArray(int[] arr) throws NullPointerException,
			ArrayIndexOutOfBoundsException {
		if (arr == null)
			throw new NullPointerException("数组不存在");
		if (arr.length < 3)
			throw new ArrayIndexOutOfBoundsException("数组没有3索引");
		return arr[3] + 1;
	}
}
