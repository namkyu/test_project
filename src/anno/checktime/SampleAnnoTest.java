package anno.checktime;

public class SampleAnnoTest {

	public static void main(String[] args) throws Exception {
		SampleProxy proxy = new SampleProxy();
		proxy.execute("test.anno.checktime.SampleObj", "doA", null);
		proxy.execute("test.anno.checktime.SampleObj", "doB", null);
		proxy.execute("test.anno.checktime.SampleObj", "doC", "CCC");
		proxy.execute("test.anno.checktime.SampleObj", "doD", null);
	}
}
