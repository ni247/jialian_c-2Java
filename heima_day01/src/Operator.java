/*
& 与 false true 结果false 只有两个是true,结果才是true
| 或 false|true 结果true  只要有一个true,结果就是true
^ 异或 true^false 结果true 两边相同是相同,相同false.不通为true.不同的就是true.相同的就是false
结果不通都是true,结果相同都是fasle
! 取反
&& 短路与,一边为false,另一边不运行
|| 短路或,一边是true.另一边不运行

 */

public class Operator {
	public static void main(String[] args) {
		System.out.println(false & true);
		System.out.println(true | true);
		System.out.println(false ^ false);
		System.out.println(false ^ true);
		System.out.println(true ^ true);

	}
}