package lx7;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random r = new Random();
		int i = r.nextInt(2);
		if (i == 0)
			System.out.println("正面");
		else
			System.out.println("反面");
	}

}
