package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Project : test_project
 * @Date : 2017-08-23
 * @Author : nklee
 * @Description :
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 21};
        System.out.println(Arrays.toString(twoSum(nums, 11)));
        System.out.println(Arrays.toString(twoSum2(nums, 11)));

    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }

                System.out.println("nums[j] : " + nums[j] + ", nums[i] : " + nums[i] + ", target : " + target);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
