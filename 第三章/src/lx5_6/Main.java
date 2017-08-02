package lx5_6;

public class Main {
	public static void main(String[] args) {
		Dog a = new Dog("spot", "Ruff");
		Dog b = new Dog("scruffy", "wruf");
		System.out.println(a);
		System.out.println(b);

		Dog c = a;
		System.out.println(a == b);// false
		System.out.println(a.equals(b));// false
		System.out.println(a == c);// true
		System.out.println(a.equals(c));// false
		System.out.println(b == c);// false
		System.out.println(b.equals(c));// false
	}
}
