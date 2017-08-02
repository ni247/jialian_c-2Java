/*
 利用循环,输出字母包含大写,小写.52个
 输出A-Z a-z
 利用编码表来实现.字母和数字的对应关系
 A-Z 65-90
 a-z 97-122
 */
public class LoopTest {
	public static void main(String[] args) {
		// for(int i=65,j=97;i<91;i++,j++){
		// System.out.println((char)i+" "+(char)j);
		// }
		char a = 'a';
		char A = 'A';
		for (int i = 0; i < 26; i++) {
			System.out.println((char) (a + i) + " " + (char) (A + i));
		}
	}
}