package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

/*
 *  业务层类
 *  接受上一层,控制层Controller的数据
 *  计算数据.并传递给dao层,操作数据库
 *  所以在类成员位置,创建Dao类的对象
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();

	public boolean addZhangWu(ZhangWu zw) {
		return true;
	}

	/*
	 * 由控制层调用
	 * 查询所有的账务数据
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}

	public List<ZhangWu> select(String start, String end) {
		return dao.select(start, end);
	}
}
