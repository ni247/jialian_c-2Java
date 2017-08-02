package lx5_6;

public class Dog {
	private String name;
	private String says;

	public Dog(String name, String says) {
		super();
		this.name = name;
		this.says = says;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", says=" + says + "]";
	}

	public String getSays() {
		return says;
	}

	public void setSays(String says) {
		this.says = says;
	}
}
