package utils.convert;

/**
 * @FileName : ConverteNumber.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class ConverteNumber {

	/**
	 * <pre>
	 * intToInteger
	 * convert int -> Integer
	 * <pre>
	 * @param intArray
	 * @return
	 */
	public static Integer[] intToInteger(int[] intArray) {
		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}

	/**
	 * <pre>
	 * integerToInt
	 * convert Integer -> int
	 * <pre>
	 * @param integerArray
	 * @return
	 */
	public static int[] integerToInt(Integer[] integerArray) {
		int[] result = new int[integerArray.length];
		for (int i = 0; i < integerArray.length; i++) {
			result[i] = integerArray[i].intValue();
		}
		return result;
	}
}
