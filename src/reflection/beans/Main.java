package reflection.beans;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("name", "남규");
		paramMap.put("age", "31");
		
		String className = "com.kyu.reflection.beans.MemberVO";
		
		Class<?> clz = Class.forName(className);
		Object obj = clz.newInstance();
		
		BeanInfo beanInfo = Introspector.getBeanInfo(clz);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		
		for(PropertyDescriptor prop: propertyDescriptors) {
			String name = prop.getDisplayName();
			Class<?> type = prop.getPropertyType();
			
			Method method = prop.getWriteMethod();
			
			if (method == null)
				continue;
			
			Object value = null;
			// type을 비교하여 parameter 값 추출
			if (type == String.class) {
				value = paramMap.get(name);
			} else if (type == int.class) {
				value = Integer.parseInt(paramMap.get(name));
			}
			
			method.invoke(obj, value);
		}
		
		System.out.println(obj);
		
	}
}
