package reflection.constructor;

public class ParentObj implements Human {

	public ParentObj() {
		System.out.println("부모 클래스!");
	}
	
	public ParentObj(String name) {
		System.out.println("parent name : " + name);
	}
	
	@Override
	public void study() {
		System.out.println("parent 공부 중!!");
	}
	
	public int giveMoney() {
		int money = 1000;
		System.out.println(money + "원 줄께!");
		return money;
	}
}
