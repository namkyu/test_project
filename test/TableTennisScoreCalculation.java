import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.junit.Test;

/**
 * @FileName : TableTennisScoreCalculation.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class TableTennisScoreCalculation {

	@Test
	public void test() {

		String start = "me";
		String next = "you";

		List<Score> scoreList = new ArrayList<>();
		scoreList.add(new Score(0, 1));
		scoreList.add(new Score(1, 1));
		scoreList.add(new Score(2, 1));
		scoreList.add(new Score(2, 2));
		scoreList.add(new Score(3, 2));
		scoreList.add(new Score(4, 2));
		scoreList.add(new Score(5, 2));
		scoreList.add(new Score(6, 2));
		scoreList.add(new Score(7, 2));
		scoreList.add(new Score(8, 2));
		scoreList.add(new Score(9, 2));

		scoreList.add(new Score(10, 9));

		for (Score score : scoreList) {
			int ScoreTotalSum = score.getMyScore() + score.getSomeoneScore();
			int 몫 = ScoreTotalSum / 2;

			// 순서 구하기
			String result = (몫 % 2) == 0 ? start : next;
			System.out.println(score.getMyScore() + " : " + score.getSomeoneScore() + " ==> " + result);
		}

	}
}

@Data
class Score {

	private int myScore;
	private int someoneScore;

	public Score(int myScore, int someoneScore) {
		this.myScore = myScore;
		this.someoneScore = someoneScore;
	}
}