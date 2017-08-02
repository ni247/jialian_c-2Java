package com.itheima.service.impl;

import java.util.List;

import com.itheima.constant.CCategoryConstant;
import com.itheima.constant.CProductConstant;
import com.itheima.dao.IProductDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.CacheUtils;

public class ProductServiceImpl implements IProductService {

	/**
	 * 查询最新商品
	 */
	@Override
	public List<Product> findNew() throws Exception {
		// 获取缓存
		Object obj = CacheUtils.getChcheByName(CProductConstant.CHCHE_NEW_PRODUCT_LIST);
		List<Product> list;
		// 4.判断数据
		if (obj == null) {
			IProductDao dao = (IProductDao) BeanFactory.getBean("ProductDao");
			list = dao.findNew();
			// 放入缓存
			CacheUtils.setChcheByName(CProductConstant.CHCHE_NEW_PRODUCT_LIST, list);
			System.out.println(this + "没有clist缓存.已设置");
		} else {
			list = (List<Product>) obj;
			System.out.println(this + "缓存中有,我就取来了");
		}
		return list;
	}

	/**
	 * 查询最热商品
	 */
	@Override
	public List<Product> findHot() throws Exception {
		// 获取缓存
		Object obj = CacheUtils.getChcheByName(CProductConstant.CHCHE_HOT_PRODUCT_LIST);
		List<Product> list;
		// 4.判断数据
		if (obj == null) {
			IProductDao dao = (IProductDao) BeanFactory.getBean("ProductDao");
			list = dao.findHot();
			// 放入缓存
			CacheUtils.setChcheByName(CProductConstant.CHCHE_HOT_PRODUCT_LIST, list);
			System.out.println(this + "没有clist缓存.已设置");
		} else {
			list = (List<Product>) obj;
			System.out.println(this + "缓存中有,我就取来了");
		}
		return list;
	}

	@Override
	public Product getById(String productId) throws Exception {
		// 获取缓存
		Object obj = CacheUtils.getChcheByName(CProductConstant.PRODUCT + productId);
		Product pro;
		// 4.判断数据
		if (obj == null) {
			IProductDao dao = (IProductDao) BeanFactory.getBean("ProductDao");
			pro = dao.getById(productId);
			// 放入缓存
			CacheUtils.setChcheByName(CProductConstant.PRODUCT + productId, pro);
			System.out.println(this + "没有obj缓存.已设置");
		} else {
			pro = (Product) obj;
			System.out.println(this + "缓存中有,我就取来了");
		}
		return pro;
	}

	@Override
	public PageBean<Product> findByPages(String cid, int currPage, int pageSize) throws Exception {
		// 获取缓存
		Object obj = CacheUtils.getChcheByName(CProductConstant.PRODUCT_LIST + "_" + cid + "_" + currPage);
		Object countObj = CacheUtils.getChcheByName(CProductConstant.PRODUCT_COUNT + "_" + cid);
		IProductDao dao = (IProductDao) BeanFactory.getBean("ProductDao");
		List<Product> list;
		// 4.判断数据
		if (obj == null) {
			list = dao.findByPages(cid, currPage, pageSize);
			// 放入缓存
			CacheUtils.setChcheByName(CProductConstant.PRODUCT_LIST + "_" + cid + "_" + currPage, list);
			System.out.println(this + "没有clist缓存.已设置");
		} else {
			list = (List<Product>) obj;
			System.out.println(this + "缓存中有,我就取来了");
		}
		int totalCount;
		// 4.判断数据
		if (countObj == null) {
			totalCount = dao.getTotalCount(cid);
			// 放入缓存
			CacheUtils.setChcheByName(CProductConstant.PRODUCT_COUNT + "_" + cid, totalCount);
			System.out.println(this + "没有clist缓存.已设置");
		} else {
			totalCount = (int) countObj;
			System.out.println(this + "缓存中有,我就取来了");
		}
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

}
