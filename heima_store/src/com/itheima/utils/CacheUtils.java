package com.itheima.utils;

import com.itheima.constant.CCommonConstant;
import com.itheima.service.impl.CategoryServiceImpl;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 管理全局缓存
 * @author Administrator
 *
 */
public class CacheUtils {
	final static CacheManager cm = CacheManager
			.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream(CCommonConstant.CHCHE_FILE_NAME));
	// 2.获取指定的缓存.
	static Cache cache = cm.getCache(CCommonConstant.DEFAULT_CHCHE_NAME);

	/**
	 * 获取指定名称缓存
	 * @param key
	 * @return
	 */
	public final static Object getChcheByName(String key) {
		Element element = cache.get(key);
		if (element == null)
			return null;
		return element.getObjectValue();
	}

	/**
	 * 设置指定名称缓存
	 * @param key
	 * @param value
	 */
	public final static void setChcheByName(String key, Object value) {
		cache.put(new Element(key, value));
	}
}
