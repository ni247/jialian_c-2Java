/*
循环语句:可以让一部分代码,反复执行

while循环

for循环,while循环同c#语言
编写格式
for(初始化变量;条件;增量){
	循环体;
}
 */
public class WhileDemo {
	public static void main(String[] args) {
		int i = 0;
		while (i < 50) {
			System.out.println("传智播客" + i);
			i++;
		}
		for (int j = 0; j < 50; j++) {
			System.out.println("我是黑马" + j);
		}
		/*
		 * 条件:当条件是true,就执行循环体,执行完循环体后,程序再次执行while中的条件.如果条件还是true,
		 * 继续执行循环体.条件是false就结束
		 */
	}
}