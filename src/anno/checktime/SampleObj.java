package anno.checktime;

public class SampleObj {

	@CheckTime
	public void doA() throws Exception {
		System.out.println("doA...");
		Thread.sleep(1000);
	}

	@CheckTime
	public void doB() throws Exception {
		System.out.println("doB...");
		Thread.sleep(2000);
	}

	@CheckTime
	public void doC(String value) throws Exception {
		System.out.println("doC..." + value);
		Thread.sleep(3000);
	}

	public void doD() throws Exception {
		System.out.println("doD...");
	}
}
