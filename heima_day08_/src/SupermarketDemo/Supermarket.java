package SupermarketDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
	public String name;
	public String ID;
	public double price;
	public ArrayList<Supermarket> arrSuperm = new ArrayList<Supermarket>();
	private Scanner sc = new Scanner(System.in);

	public Supermarket(String name, String ID, double price) {
		this.name = name;
		this.ID = ID;
		this.price = price;
	}

	public Supermarket() {
		addGood("草莓", "9001", 105);
		addGood("芒果", "9002", 125);
		addGood("西瓜", "9003", 15);
	}

	public boolean addGood(String name, String ID, double price) {
		if (findIndexByID(ID) == -1) {
			arrSuperm.add(new Supermarket(name, ID, price));
			return true;
		} else
			return false;
	}

	public void delGood(int index) {
		if (arrSuperm.size() > index)
			arrSuperm.remove(index);
	}

	public boolean delGood() {
		System.out.println("请输入您要删除的水果编号");
		String ID = sc.next();
		int index = findIndexByID(ID);
		if (index != -1) {
			delGood(index);
			return true;
		} else
			return false;
	}

	// 通过编号找索引
	public int findIndexByID(String ID) {
		for (int i = 0; i < arrSuperm.size(); i++) {
			if (arrSuperm.get(i).ID.equals(ID))
				return i;
		}
		return -1;
	}

	public boolean editGood(int index, String name, String ID, double price) {
		if (arrSuperm.size() > index) {
			arrSuperm.set(index, new Supermarket(name, ID, price));
			return true;
		} else
			return false;
	}

	public void printAllGoods() {
		System.out
				.println("=======================商品库存清单=======================");
		System.out.println("商品编号" + "\t\t" + "商品名称" + "\t\t" + "商品单价" + "\t\t");
		Supermarket superM;
		for (int i = 0; i < arrSuperm.size(); i++) {
			superM = arrSuperm.get(i);
			System.out.println(superM.ID + "\t\t" + superM.name + "\t\t"
					+ superM.price + "\t\t");
		}
	}

	public boolean addGood() {
		System.out.println("请输入新水果的名称");
		String name = sc.next();
		System.out.println("请输入新水果的编号");
		String ID = sc.next();
		System.out.println("请输入新水果的价格");
		double price = sc.nextDouble();
		return addGood(name, ID, price);
	}

	public boolean editGood() {
		System.out.println("请输入你要修改的水果编号");
		String ID = sc.next();
		int index = findIndexByID(ID);
		if (index == -1) {
			System.out.println("未在数据库中查找到该水果");
			return false;
		}
		System.out.println("请输入新的水果名称");
		String name = sc.next();
		System.out.println("请输入新的水果的单价");
		double price = sc.nextDouble();
		return editGood(index, name, ID, price);
	}

	public boolean printMenu() {
		System.out.println();
		System.out
				.println("=======================欢迎光临彬才的超市=======================");
		System.out.println("1.货品清单");
		System.out.println("2.添加新货品");
		System.out.println("3.删除货物");
		System.out.println("4.修改货物");
		System.out.println("5.退出系统");
		System.out.println("请您选择要操作的功能序号");
		int inputInt = sc.nextInt();
		switch (inputInt) {
		case 1:
			printAllGoods();
			break;
		case 2:
			if (addGood())
				System.out.println("新货物添加完毕");
			else
				System.out.println("新货物添加失败");
			break;
		case 3:
			if (delGood())
				System.out.println("水果信息删除完毕");
			else
				System.out.println("水果信息删除失败");
			break;
		case 4:
			if (editGood())
				System.out.println("水果信息修改成功");
			else
				System.out.println("水果信息修改失败");
			break;
		case 5:
			System.out.println("系统关闭");
			return false;
		default:
			System.out.println("输入有误,请重新输入");
			break;
		}
		return true;
	}

	public void startWork() {
		while (true) {
			if (!printMenu())
				return;
		}
	}
}
