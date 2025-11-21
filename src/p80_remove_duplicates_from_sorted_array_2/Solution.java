package p80_remove_duplicates_from_sorted_array_2;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        System.out.println("Start array: " + Arrays.toString(nums));
        int k = 1;
        boolean second = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[k - 1] == nums[i + 1] && !second) {
                nums[k++] = nums[i + 1];
                second = true;
            } else if (nums[k - 1] < nums[i + 1] && second) {
                nums[k++] = nums[i + 1];
                second = false;
            } else if (nums[k - 1] < nums[i + 1]) {
                nums[k++] = nums[i + 1];
            }
        }
        System.out.println("End array: " + Arrays.toString(nums));
        return k;
    }

    public int removeDuplicatesBest(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int k = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 2])
                nums[k++] = nums[i];
        }

        return k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeDuplicates(new int[]{1}));
        System.out.println(s.removeDuplicates(new int[]{1, 2}));
        System.out.println(s.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4}));
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));

        System.out.println(s.removeDuplicatesBest(new int[]{1}));
        System.out.println(s.removeDuplicatesBest(new int[]{1, 2}));
        System.out.println(s.removeDuplicatesBest(new int[]{1, 1, 2}));
        System.out.println(s.removeDuplicatesBest(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(s.removeDuplicatesBest(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4}));
        System.out.println(s.removeDuplicatesBest(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(s.removeDuplicatesBest(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
