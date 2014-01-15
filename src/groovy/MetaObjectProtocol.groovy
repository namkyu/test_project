package groovy

/**
 * @FileName : MetaObjectProtocol.groovy
 * @Project : test_project
 * @Date : 2013. 10. 15.
 * @작성자 : nklee
 * @프로그램설명 : The meta object protocol allows to add dynamically at runtime methods and properties.
 */
class MetaObjectProtocol {

	def map

	Object getProperty (String property) {
		println "Setting this property"
		return 5
	}

	void setProperty (String property, Object o) {
		println "Hello"
	}

	/**
	 * <pre>
	 * methodMissing
	 *
	 * <pre>
	 * @param name 동적 메서드 명이 들어온다.
	 * @param args 동적 메서드의 매개변수가 배열로 생성
	 * @return
	 */
	def methodMissing (String name, args) {
		def s = name.toUpperCase()
		println args
		if (s.startsWith("HELLO")) {
			println "This method stats with Hello. Full name $name"
		} else {
			println "This method is missing"
		}
	}

	static void main(def args) {
		def test = new MetaObjectProtocol()
		test.hall(33)
		test.helloMethod()
		test.Hallo() // 동적 메서드 호출 시 methodMissing 메서드 호출
		test.test = 5 // 동적 변수 생성 시 setProperty, getProperty 호출
		println test.test
	}
}
