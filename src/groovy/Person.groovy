package groovy

/**
 * @FileName : Person.groovy
 * @Project : test_project
 * @Date : 2013. 10. 14.
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class Person {

	String firstName
	String lastName
	int age
	def address

	static void main(def args) {
		Person p = new Person();
		p.setFirstName("namkyu")
		p.lastName = "Lee"
		p.address = "guri"
		println p.firstName + " " + p.lastName

		p = new Person(firstName: "namkyu2", lastName: "Lee")
		println p.firstName + " " + p.lastName
	}
}
