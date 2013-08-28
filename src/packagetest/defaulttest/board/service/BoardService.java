package packagetest.defaulttest.board.service;


/**
 * @FileName : BoardService.java
 * @Project : test_project
 * @Date : 2013. 6. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class BoardService {

	void defaultAccessConstraint() {
		System.out.println("board service default access constraint");
	}

	public void publicAccessConstraint() {
		System.out.println("board service public access constraint");
	}
}
