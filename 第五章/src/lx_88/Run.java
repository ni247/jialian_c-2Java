package lx_88;

import org.junit.Test;

public class Run {

	@Test
	public void exercise3() {
		Cat c1 = new Cat();
	}

	@Test
	public void exercise4() {
		Cat c1 = new Cat("苗苗");
	}

	@Test
	public void exercise5() {
		Dog d = new Dog();
		d.bark();
		d.bark(3);
	}

	@Test
	public void exercise6() {
		Dog d = new Dog();
		d.bark(1, "3");
		d.bark("3", 1);
	}

	@Test
	public void exercise7() {
		Person p = new Person();
	}
}
