package groovy

/**
 * @FileName : TypeTest.groovy
 * @Project : test_project
 * @Date : 2013. 10. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
class TypeTest {

	public static main(args) {
		int i = 1
		int j = i + 3
		int k = i.plus(3)

		assert(k == 4)
		println i.getClass().getName()
		println j.getClass().getName()
		println k.getClass().getName()

		// Automatic type assignement
		def value = 1.0F
		println value.getClass().getName()

		def value2 = 1
		println value2.getClass().getName()

		value2 = value2 / 2
		println  value2
		println value2.getClass().getName()
	}
}
