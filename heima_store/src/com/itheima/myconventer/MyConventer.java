package com.itheima.myconventer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

public class MyConventer implements Converter {

	@Override
	public Object convert(Class arg0, Object arg1) {
		// arg0 要转换的类型
		// arg1 页面上传入的值

		// 将object转成date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return simpleDateFormat.parse((String) arg1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
