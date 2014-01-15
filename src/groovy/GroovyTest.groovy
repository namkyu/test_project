package groovy

/**
 * @FileName : GroovyTest.groovy
 * @Project : test_project
 * @Date : 2013. 10. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class GroovyTest {

	static void main(def args) {

		// loop test
		def mylist = [1, 2, "Lars", "4"]
		mylist.each {
			print it + " "
		}
		newLine()
		mylist.each {
			value -> print value + " "
		}

		// method test
		newLine()
		println "1 + 4 = " + sum(1, 4);
		println "3 + 4 = " + sum(3, 4);

		// optional parameter test
		newLine()
		println "optionalParameters=" + optionalParameters(1, 1)
		println "optionalParameters=" + optionalParameters(1, 2, 4)

		// support method test
		newLine()
		5.times {println "Times + $it"}
		1.upto(3) {println "Up + $it"}
		4.downto(1) {println "Down + $it"}
		(1..6).each {println "Range $it"}
	}


	static sum(a, b) {
		a + b;
	}

	static optionalParameters(a, b, c=1) {
		a + b + c
	}

	static newLine() {
		println "\n"
	}
}
