/*
初始化一个类后,会给类中的属性赋默认值
需要注意的是String因为是引用类型,所以默认值是null
double会是0
 */
public class TestPhone {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.color = "土豪金";
		p.brand = "爱立信";
		p.size = 5;
	}
}