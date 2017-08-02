/*
  方法的定义格式
  修饰符 返回值类型 方法的名字(参数列表...)
    方法的功能主体
	return;
	
	修饰符:先固定写法public static 
	返回值类型:方法在运算后,结果的数据规范
	方法名:自定义名字,满足标识符规范,方法首字母小写,后面每个单词首字母大写
	参数列表:方法的运算过程中,是否有位置的数据,如果有位置的数据,定义在参数列表上
	return:方法的返回,将计算的结果返回,结束方法
	
	

 */

public class MethodDemo {
	public static void main(String[] args) {
		int c = GetArea(3, 2);
		System.out.println("面积是" + c);
	}

	/*
	 * 计算长方形的面积
	 */
	public static int GetArea(int width, int height) {
		return width * height;
	}
}