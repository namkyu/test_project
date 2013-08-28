package reflection.constructor;

import java.lang.reflect.Constructor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String className = "com.kyu.reflection.constructor.ChildObj";
		Class<?> clz = Class.forName(className);
		System.out.println(clz);
		
		Constructor<?> constructor = clz.getConstructor(String.class, int.class);
		Human human = (Human) constructor.newInstance("namkyu", 31);
		
		human.study();
		
		/*
		 * ChildObj의 study() 메소드를 리플렉션을 이용하여 호출해 보자.
		 * ChildObj 객체 생성 후 이를 ParentObj 클래스에 담았다. 그런 후 study() 메소드를 찾았지만 ParentObj
		 * 클래스에는 study()메소드가 존재하지 않기 때문에 호출하지 못함.
		 * 결국 다형성을 해결하지 못하였고, 이를 보안하기 위해 Human 인터페이스를 설계하여 study()를 선언하였다.
		 * ParentObj는 Human을 구현하여 study()메소드를 생성하고, ChildObj는 ParentObj의 study()메소드를 재정의 하였다.
		 * 음. 이렇게 하니 ParentObj의 study()메소드는 불필요한 코드가 되어 버린다.
		 * 결국 이를 해결하기 위해서는 상속 구조 관계를 끊어 버리고, 인터페이스 구조로 변경하는 것이 유연할 것 같다.
		 * 
		 * 그럼 다형성을 유지하면서 부모 클래스의 특정 함수를 사용하고 싶을 땐 어떻게 할까?
		 * public class ChildObj extends ParentObj implements Human 와 같은 관계를 형성한다.
		 * 
		 * */
		
	}
}
