package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @FileName : CommandHelloWorld.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class CommandHelloWorld extends HystrixCommand<String> {

	private final String name;

	/**
	 * @param group
	 */
	protected CommandHelloWorld(String name) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.name = name;
	}

	/**
	 * <pre>
	 * run
	 *
	 * <pre>
	 * @return
	 * @throws Exception
	 */
	@Override
	protected String run() throws Exception {
		return "Hello " + name + "!";
	}
}
