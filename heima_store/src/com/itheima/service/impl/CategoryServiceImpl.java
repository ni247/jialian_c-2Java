package com.itheima.service.impl;

import java.io.InputStream;
import java.util.List;

import com.itheima.constant.CCategoryConstant;
import com.itheima.constant.CCommonConstant;
import com.itheima.dao.ICategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.ICategoryService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.CacheUtils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CategoryServiceImpl implements ICategoryService {

	@Override
	public List<Category> findAll() throws Exception {

		// 3.通过缓存获取数据
		Object obj = CacheUtils.getChcheByName(CCategoryConstant.CACHE_CATEGORY_LIST);
		List<Category> list;
		// 4.判断数据
		if (obj == null) {
			ICategoryDao dao = (ICategoryDao) BeanFactory.getBean("CategoryDao");
			list = dao.findAll();
			// 放入缓存
			CacheUtils.setChcheByName(CCategoryConstant.CACHE_CATEGORY_LIST, list);
			System.out.println("没有clist缓存.已设置");
		} else {
			list = (List<Category>) obj;
			System.out.println("缓存中有,我就取来了");
		}
		return list;
	}

	public static void main(String[] args) {
		InputStream resourceAsStream = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
		System.out.println(resourceAsStream);

	}

}
