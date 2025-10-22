package p26_remove_duplicates_from_sorted_array;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        System.out.println("Start array: " + Arrays.toString(nums));
        int k = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                nums[k] = nums[i + 1];
                k++;
            }
        }
        System.out.println("End array: " + Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1}));
        System.out.println(solution.removeDuplicates(new int[]{1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4}));
    }
}
