package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Linkman;

public interface ILinkmanDao {

	boolean addLinkman(Linkman link) throws Exception;

	List<Linkman> getList(DetachedCriteria criteria) throws Exception;

}
