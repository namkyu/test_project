package anno.checktime;

public class SampleAnnoTest {

	public static void main(String[] args) throws Exception {
		SampleProxy proxy = new SampleProxy();
		proxy.execute("anno.checktime.SampleObj", "doA", null);
		proxy.execute("anno.checktime.SampleObj", "doB", null);
		proxy.execute("anno.checktime.SampleObj", "doC", "CCC");
		proxy.execute("anno.checktime.SampleObj", "doD", null);
	}
}
