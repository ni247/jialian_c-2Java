package com.itheima.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itheima.domain.Province;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Demo {
	@Test
	// 数组
	public void f1() {
		String[] arr = { "aaa", "bb", "cc" };
		JSONArray json = JSONArray.fromObject(arr);
		System.out.println(json);
	}

	@Test
	// 集合
	public void f2() {
		List<String> list = new ArrayList<>();
		list.add("11");
		list.add("11");
		list.add("11");
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json);
	}

	@Test
	// bean
	public void f3() {
		Province p = new Province();
		p.setName("背景");
		p.setProvinceID(1);
		JSONObject fromObject = JSONObject.fromObject(p);
		System.out.println(fromObject);
	}

	@Test
	// map集合
	public void f4() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "被禁");
		map.put("value", 1);
		JSONObject object = JSONObject.fromObject(map);
		System.out.println(object);
	}

	@Test
	// list中放javabean
	public void f5() {
		List<Province> list = new ArrayList<Province>();
		list.add(new Province(1, "bj"));
		list.add(new Province(2, "tj"));
		list.add(new Province(3, "nj"));
		list.add(new Province(4, "dj"));
		JSONArray object = JSONArray.fromObject(list);
		System.out.println(object);
	}
}