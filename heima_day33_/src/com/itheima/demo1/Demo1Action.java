package com.itheima.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 完全解耦合方式
 * @author Administrator
 *
 */
public class Demo1Action extends ActionSupport {

	public String execute() {
		System.out.println("默认方法运行l");
		// 获取运行环境
		ActionContext context = ActionContext.getContext();
		// 打印所有的参数
		Map<String, Object> map = context.getParameters();
		for (String key : map.keySet()) {
			// 注意,参数是字符串数组形式
			String[] pas = (String[]) map.get(key);
			System.out.println("key:" + key + Arrays.toString(pas));
		}
		// 往request中存值
		context.put("msg", "request中存放的");
		// 往session中存执
		context.getSession().put("msg", "session中存放的");
		// 往context中存执
		context.getApplication().put("msg", "context中存放");
		return SUCCESS;
	}
}
