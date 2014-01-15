package groovy

/**
 * @FileName : MapTest.groovy
 * @Project : test_project
 * @Date : 2013. 10. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class MapTest {

	static void main(def args) {
		def map2 = ["a":1, "b":2]
		println map2["a"]
		map2["c"] = 3
		println map2["c"]
	}
}
