package lx_85;

public class Run {
	public static void main(String[] args) {
		Run r = new Run();
		r.say();
	}

	public void say() {
		System.out.println("say");
		speak();
		this.speak();
	}

	public void speak() {
		System.out.println("speak");
	}
}
