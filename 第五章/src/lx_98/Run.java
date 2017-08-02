package lx_98;

import org.junit.Test;

public class Run {
	String s;
	{
		s = "123";
	}

	Run() {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Run r = new Run();
	}

}
