package p1_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer, Integer> sums = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (sums.containsKey(nums[i])) {
                indexes[0] = sums.get(nums[i]);
                indexes[1] = i;
                break;
            }
            sums.put(target - nums[i], i);
        }

        return indexes;
    }

    public int[] twoSumBest(int[] nums, int target) {
        Map<Integer, Integer> sums = new HashMap<>();
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (sums.containsKey(nums[start])) {
                return new int[]{sums.get(nums[start]), start};
            }
            sums.put(target - nums[start], start);

            if (sums.containsKey(nums[end])) {
                return new int[]{sums.get(nums[end]), end};
            }
            sums.put(target - nums[end], end);
            start++;
            end--;
        }

        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0, 1, 2, 3};

        System.out.println(Arrays.toString(s.twoSum(nums, 3)));
        System.out.println(Arrays.toString(s.twoSumBest(nums, 3)));
    }
}