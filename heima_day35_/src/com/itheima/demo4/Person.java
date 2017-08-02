package com.itheima.demo4;

public class Person {
	private String pname;
	private Car1 car1;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Car1 getCar1() {
		return car1;
	}

	public void setCar1(Car1 car1) {
		this.car1 = car1;
	}

	public Person(String pname, Car1 car1) {
		super();
		this.pname = pname;
		this.car1 = car1;
	}

	@Override
	public String toString() {
		return "Person [pname=" + pname + ", car1=" + car1 + "]";
	}
}
