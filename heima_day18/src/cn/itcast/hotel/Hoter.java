package cn.itcast.hotel;

import java.util.ArrayList;

/**
 * 酒店类
 * 
 * @author JiaLian
 * 
 */
public class Hoter {
	private ArrayList<Employee> listEmp = new ArrayList<>();

	public ArrayList<Employee> getListEmp() {
		return listEmp;
	}

	public void setListEmp(ArrayList<Employee> listEmp) {
		this.listEmp = listEmp;
	}

	/**
	 * 添加员工
	 * 
	 * @param p
	 */
	public void addEmpoyee(Employee p) {
		listEmp.add(p);
	}
}
