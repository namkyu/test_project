package packagetest.defaulttest.board.controller;

import packagetest.defaulttest.DefaultClass;
import packagetest.defaulttest.board.service.BoardService;

/**
 * @FileName : Board.java
 * @Project : test_project
 * @Date : 2013. 6. 13.
 * @작성자 : 이남규
 * @프로그램설명 :
 */
public class BoardController extends DefaultClass {

	private final BoardService boardService = new BoardService();

	public void test() {
		protectedAccessConstraint(); // protected
		boardService.publicAccessConstraint(); // public
	}
}
