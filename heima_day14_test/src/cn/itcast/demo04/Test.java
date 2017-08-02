package cn.itcast.demo04;

/*
 * 接口不继承objcect类
 */
public class Test {
	public static void main(String[] args) {
		// 创建1个经理,2个服务员,2个厨师
		Hoter h = new Hoter();
		h.addEmpoyee(new Manger("张三", 11, 333333));
		h.addEmpoyee(new Server("酸菜1", 12));
		h.addEmpoyee(new Server("酸菜2", 12));
		h.addEmpoyee(new Cook("大雨", 12));
		h.addEmpoyee(new Cook("大雨", 12));
		for (int i = 0; i < h.getListEmp().size(); i++) {
			h.getListEmp().get(i).work();
		}
	}
}
