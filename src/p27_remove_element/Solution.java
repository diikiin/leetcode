package p27_remove_element;

import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        System.out.println("Start array: " + Arrays.toString(nums));
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println("End array: " + Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
