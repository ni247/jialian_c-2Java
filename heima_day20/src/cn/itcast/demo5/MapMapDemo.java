package cn.itcast.demo5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * Map集合的嵌套.Map中存储的还是Map集合
 * 要求:
 */
public class MapMapDemo {
	public static void main(String[] args) {
		HashMap<String, String> javase = new LinkedHashMap<String, String>();
		HashMap<String, String> javaee = new LinkedHashMap<String, String>();
		javase.put("001", "张三");
		javase.put("002", "李四");

		javaee.put("001", "王五");
		javaee.put("002", "赵六");

		HashMap<String, HashMap<String, String>> czbk = new HashMap<String, HashMap<String, String>>();
		czbk.put("基础班", javase);
		czbk.put("就业班", javaee);
		entry(czbk);
	}

	static void entry(HashMap<String, HashMap<String, String>> czbk) {
		Set<Map.Entry<String, HashMap<String, String>>> setEntry = czbk
				.entrySet();

		//迭代器
		Iterator<Map.Entry<String, HashMap<String, String>>> itClassName = setEntry
				.iterator();
		while (itClassName.hasNext()) {
			Map.Entry<String, HashMap<String, String>> hashMap = itClassName
					.next();
			String className = hashMap.getKey();
			HashMap<String, String> cc = hashMap.getValue();
			Set<Map.Entry<String, String>> setEntry1 = cc.entrySet();
			Iterator<Map.Entry<String, String>> itStudentID = setEntry1
					.iterator();
			while (itStudentID.hasNext()) {
				Map.Entry<String, String> entrySI = itStudentID.next();
				System.out.println("班级:" + className + "学号:" + entrySI.getKey()
						+ "名称:" + entrySI.getValue());
			}
		}

		System.out.println("======================");
		//增强for
		for (Map.Entry<String, HashMap<String, String>> entry : setEntry) {
			String className = entry.getKey();
			HashMap<String, String> studentID = entry.getValue();
			Set<Map.Entry<String, String>> setEntryStudentID = studentID
					.entrySet();
			for (Map.Entry<String, String> entryneibu : setEntryStudentID) {
				System.out.println("班级:" + className + "学号:"
						+ entryneibu.getKey() + "名称:" + entryneibu.getValue());
			}
		}

	}

	static void keySet(HashMap<String, HashMap<String, String>> czbk) {
		Set<String> classNameSet = czbk.keySet();
		//增强for写法
		for (String className : classNameSet) {
			HashMap<String, String> hashMap = czbk.get(className);
			Set<String> studentIDSet = hashMap.keySet();
			for (String studentID : studentIDSet) {
				System.out.println("班级:" + className + "学号:" + studentID
						+ "名称:" + hashMap.get(studentID));
			}
		}

		System.out.println("===============");
		//迭代器方法
		//迭代器中需要注意的是每次调用next,指针都会往下偏
		Iterator<String> iteratorClassName = classNameSet.iterator();
		while (iteratorClassName.hasNext()) {
			String className = iteratorClassName.next();
			HashMap<String, String> hashMap = czbk.get(className);
			Iterator<String> itStudentID = hashMap.keySet().iterator();
			while (itStudentID.hasNext()) {
				String studentID = itStudentID.next();
				System.out.println("班级:" + className + "学号:" + studentID
						+ "名称:" + hashMap.get(studentID));
			}
		}
	}
}
