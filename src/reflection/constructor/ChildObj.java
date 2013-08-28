package reflection.constructor;

public class ChildObj extends ParentObj implements Human {
	
	static {
		System.out.println("클래스 로딩!");
	}
	
	public ChildObj(String name, int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
	@Override
	public void study() {
		giveMoney();
		System.out.println("childe 공부 중!" );
	}
}
