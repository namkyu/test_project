package reflection.field;

import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String className = "com.kyu.reflection.field.MemberVO";
		
		Class<?> clz = Class.forName(className);
		Object obj = clz.newInstance();
		
		Field field = clz.getDeclaredField("name");
		field.setAccessible(true); // private 접근제어자가 붙은 멤버 변수에 접근 가능하게 설정
		field.set(obj, "남규");
		
		System.out.println(obj);
	}
}
