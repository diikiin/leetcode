package p3708_longest_fibonacci_subarray;

public class Solution {
    public int longestSubarray(int[] nums) {
        int longest = 2, current = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] + nums[i - 1] == nums[i]) {
                current++;
            } else {
                if (current > longest) longest = current;
                current = 2;
            }
        }
        return Math.max(current, longest);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubarray(new int[]{1, 1, 1, 1, 2, 3, 5, 1}));
        System.out.println(s.longestSubarray(new int[]{5, 2, 7, 9, 16}));
        System.out.println(s.longestSubarray(new int[]{1000000000, 1000000000, 1000000000}));
    }
}
