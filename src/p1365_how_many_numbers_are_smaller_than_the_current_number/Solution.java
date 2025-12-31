package p1365_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            res[i] = count;
        }
        return res;
    }

    public int[] smallerNumbersThanCurrentBest(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) count[num]++;

        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));

        System.out.println(Arrays.toString(s.smallerNumbersThanCurrentBest(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrentBest(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrentBest(new int[]{7, 7, 7, 7})));
    }
}
