package groovy

/**
 * @FileName : ClosureTest.groovy
 * @Project : test_project
 * @Date : 2013. 10. 15.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class ClosureTest {

	static void main(def args) {
		List<Integer> list = [5, 6, 7, 8]
		list.each ({line -> println line})
		list.each({println it})
	}
}
