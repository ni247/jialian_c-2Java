package cn.itcast.demo1;

import java.io.File;
import java.io.FileFilter;

/*
 * 自定义过滤器
 * 实现FileFileter接口,重写抽象方法
 */
public class MyFileter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(".java");
	}
}
