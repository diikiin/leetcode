package p1929_concatenation_of_array;

import java.util.Arrays;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(s.getConcatenation(new int[]{1, 3, 2, 1})));
    }
}
