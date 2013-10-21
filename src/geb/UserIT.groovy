package geb

import spock.lang.Stepwise

/**
 * @FileName : UserIT.groovy
 * @Project : test_project
 * @Date : 2013. 10. 15.
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Stepwise
class UserIT {

	static void main(def args) {
		Browser.drive {
			go "http://myapp.com/login"

			assert $("h1").text() == "Please Login"

			$("form.login").with {
				username = "admin"
				password = "password"
				login().click()
			}

			assert $("h1").text() == "Admin Section"
	}
}
}
