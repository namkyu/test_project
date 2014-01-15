package groovy

/**
 * @FileName : RegularExpressionTest.groovy
 * @Project : test_project
 * @Date : 2013. 10. 15.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class RegularExpressionTest {

	static void main(def args) {
		def text = "John Jimbo jingeled happily ever after"

		if (text ==~ /(\w*\W+)*/) {
			println "match was successful"
		} else {
			println "match was not successful"
		}

		if (text =~ /(\w*\W+)*/){
			println "Find was successful"
		} else {
			println "Find was not successful"
		}

		if (text ==~ /^J.*/){
			println "There was a match"
		} else {
			println "No match found"
		}

		def newText = text.replaceAll(/\w+/, "hubba")
		println newText
	}
}
