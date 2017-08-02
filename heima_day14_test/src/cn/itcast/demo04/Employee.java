package cn.itcast.demo04;

public abstract class Employee {
	public Employee() {

	}

	public Employee(String name, int id) {
		this.name = name;
		this.ID = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private int ID;

	public abstract void work();
}
