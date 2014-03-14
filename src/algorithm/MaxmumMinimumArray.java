package algorithm;

import java.util.Arrays;

/**
 * @FileName : MaxmumMinimumArray.java
 * @Project : test_project
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class MaxmumMinimumArray {


	public static void main(String[] args) {
		largestAndSmallestInArray(new int[]{-20, 34, 21, -87, 92, Integer.MAX_VALUE});
		largestAndSmallestInArray(new int[]{10, Integer.MIN_VALUE, -2});
		largestAndSmallestInArray(new int[]{Integer.MAX_VALUE, 40, Integer.MAX_VALUE});
		largestAndSmallestInArray(new int[]{1, -1, 2, -3});
		largestAndSmallestInArray(new int[]{1, 1, 2, 33});
		largestAndSmallestInArray(new int[]{1, 2, 3, 4, 5});
	}

	public static void largestAndSmallestInArray(int[] numbers) {
		int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }

		System.out.println("\ngiven integer array : " + Arrays.toString(numbers));
		System.out.println("largest number in array is : " + largest);
		System.out.println("smallest number in array is : " + smallest);
	}
}
