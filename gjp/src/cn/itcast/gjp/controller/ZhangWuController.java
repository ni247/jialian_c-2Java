package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

/*
 * 控制器层
 * 接受视图层数据,并吧数据传递给service层
 * 所以在成员位置,创建service对象
 */
public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();

	public boolean addZhangWu(ZhangWu zw) {
		if (zw == null)
			return false;
		return true;
	}

	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}

	public List<ZhangWu> select(String start, String end) {

		return service.select(start, end);
	}

}
