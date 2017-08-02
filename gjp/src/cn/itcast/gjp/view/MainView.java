package cn.itcast.gjp.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

/*
 * 视图层,使用看到和操作的界面
 * 会将数据传递给控制层.
 */
public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	private Scanner sc = new Scanner(System.in);

	/*
	 * 主菜单显示,接受键盘输入的功能,并根据输入调用不同的功能方法
	 */
	public void run() {
		//		ZhangWuController controller = new ZhangWuController();
		//创建scanner类对象,返回键盘输入

		while (true) {
			System.out.println("管家婆家庭记账软件");
			System.out.println("1.添加账户 2.编辑账务 3.删除账务 4.查询账务 5.退出");
			int input = sc.nextInt();
			switch (input) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.out.println("退出中");
				return;
			default:
				break;
			}
		}
	}

	/*
	 *  定义方法 selectZhangwu()
	 *  显示查询的方式1.所有查询 2条件查询
	 *  接受用户的选择
	 */
	public void selectZhangWu() {
		System.out.println("1.所有查询,2.条件查询");
		int selectedChooser = sc.nextInt();
		switch (selectedChooser) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;

		default:
			break;
		}
	}

	/*
	 * 查询所有账务数据
	 */
	public void selectAll() {
		//调用控制层,查询所有账务数据
		List<ZhangWu> list = controller.selectAll();
		print(list);
	}

	private void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		for (ZhangWu zw : list)
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t"
					+ zw.getZhanghu() + "\t" + zw.getMoney() + "\t"
					+ zw.getCreatetime() + "\t" + zw.getDescription());
	}

	/*
	 * 条件查询账户数据
	 * 提供用户的输入日期,开始日期和结束日期
	 * 
	 */
	public void select() {
		System.out.println("时间格式:xxxx-xx-xx");
		sc = new Scanner(System.in);
		System.out.println("请输入开始日期:");
		String startDate = sc.nextLine();
		System.out.println("请输入结束如期:");
		String endDate = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.parse(startDate);
			sdf.parse(endDate);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		//调用controller层方法.传递日期,获取查询结果
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("没有查询到数据");

	}
}
