package cn.itcast.demo01;

/*  java.lang包不需要导入,可以直接使用
 *   按照ctrl键可以看到方法的源码
 *   如果是重写或者实现的代码.可以选下面这栏
 *   
 *   jdk包含
 *   jre  
 *     jre包含jvm,运行时需要的核心类库
 *   和开发工具
 *   
 *   
 *   java的压缩文件格式 jar
 */
public class JavaEE extends Employee {

	@Override
	public void work() {
		System.out.println("我也在工作");
	}

}
