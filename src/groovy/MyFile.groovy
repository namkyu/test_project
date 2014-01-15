package groovy

/**
 * @FileName : MyFile.groovy
 * @Project : test_project
 * @Date : 2013. 10. 15.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class MyFile {

	static void main(def args) {
		// Write just the content of the file to the console
		File file = new File("E:\\test\\groovy\\test.txt")
		file.eachLine {line -> println  line}

		// adds a line number in front of each line to the console
		def lineNumber = 0;
		file = new File("E:\\test\\groovy\\test.txt")
		file.eachLine {
			line -> lineNumber++
			println "$lineNumber: $line"
		}
	}
}
