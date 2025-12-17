package p485_max_consecutive_ones;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) count++;
            else if (count > max) {
                max = count;
                count = 0;
            } else count = 0;
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        System.out.println(s.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }
}
