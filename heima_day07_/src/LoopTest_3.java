/*
这边需要注意的是/t是制表位,并不是每次都制造相同的空格
 */
public class LoopTest_3 {
	public static void main(String[] args) {
		printTab(9);
	}

	public static void printTab(int height) {
		for (int i = 1; i < height; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}
}