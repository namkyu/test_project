import java.math.BigDecimal;


/**
 * @FileName : PointCalculation.java
 * @Project : test_project
 * @Date : 2012. 6. 14.
 * @작성자 : 이남규
 * @프로그램설명 : 소수점 계산 로직
 */
public class BigDecimalCalculation {

	/**
	 * <pre>
	 * main
	 *
	 * <pre>
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimalCalculation pointCalculation = new BigDecimalCalculation();

		int amount = 100; // 광고비
		int weight = 100; // 가중치
		int totalWeight = 1000; // total 가중치

		pointCalculation.job(amount, weight, totalWeight);
	}

	/**
	 * <pre>
	 * job
	 *
	 * <pre>
	 */
	public void job(int amount, int weight, int totalWeight) {
		BigDecimal amountBigDecimal = new BigDecimal(amount);
		BigDecimal weightBigDecimal = new BigDecimal(weight);
		BigDecimal totalWeightBigDecimal = new BigDecimal(totalWeight);

		BigDecimal divideResult = weightBigDecimal.divide(totalWeightBigDecimal);
		BigDecimal dailyBudget = amountBigDecimal.multiply(divideResult);

		System.out.println("divideResult : " + divideResult);
		System.out.println("dailyBudget : " + dailyBudget.toString());

		long budgetResult = decimalScale(dailyBudget.toString(), 0, 2);
		System.out.println("budgetResult : " + budgetResult);
	}

	/**
	 * <pre>
	 * decimalScale
	 *
	 * <pre>
	 * @param decimal
	 * @param loc 자릿수 제한 위치 (1자리 : 1, 2자리 : 2, 3자리 : 3)
	 * @param mode 1:내림, 2:반올림, 3:올림
	 * @return
	 */
	public long decimalScale(String decimal, int loc, int mode) {
		BigDecimal bigDecimal = new BigDecimal(decimal);
		BigDecimal result = null;

		if (mode == 1) {
			result = bigDecimal.setScale(loc, BigDecimal.ROUND_DOWN); // 내림
		} else if (mode == 2) {
			result = bigDecimal.setScale(loc, BigDecimal.ROUND_HALF_UP); // 반올림
		} else if (mode == 3) {
			result = bigDecimal.setScale(loc, BigDecimal.ROUND_UP); // 올림
		}

		return result.longValue();
	}

}
