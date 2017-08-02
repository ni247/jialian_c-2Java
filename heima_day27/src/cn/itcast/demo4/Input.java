package cn.itcast.demo4;

//那么问题来了.那lock类如何锁一个类

/*
 *  输入的线程,对资源对象Resuorce中成员赋值
 *  1次赋值,张三,男
 *  下一次赋值 李四,女
 *  
 *  需要注意,必须用锁对象调用wait lock方法
 */
public class Input implements Runnable {
	private Resource r;

	public Input(Resource r) {
		super();
		this.r = r;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			//为什么加了锁之后还是不行
			synchronized (r) {
				if (r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (i % 2 == 0) {
					r.name = "张三";
					r.sex = "男";
				} else {
					r.name = "lisi";
					r.sex = "nv";
				}
				i++;
				r.flag = true;
				r.notify();
			}
		}
	}
}
