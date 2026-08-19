package p3471_find_the_largest_almost_missing_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        Map<Integer, Boolean> used = new HashMap<>(k);
        int i = 0;
        while (i <= nums.length - k) {
            used.clear();
            for (int j = i; j < i + k; j++) {
                if (used.containsKey(nums[j])) continue;
                numsCount.put(nums[j], numsCount.getOrDefault(nums[j], 0) + 1);
                used.put(nums[j], true);
            }
            i++;
        }

        int res = -1;
        for (Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
            if (entry.getValue() == 1) {
                res = Math.max(entry.getKey(), res);
            }
        }

        return res;
    }

    public int largestIntegerBest(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            int res = nums[0];
            for (int num : nums) res = Math.max(res, num);
            return res;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = -1;
        if (k == 1) {
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                if (e.getValue() == 1) {
                    res = Math.max(res, e.getKey());
                }
            }
            return res;
        }

        if (freq.get(nums[0]) == 1) {
            res = nums[0];
        }
        if (freq.get(nums[n - 1]) == 1) {
            res = Math.max(res, nums[n - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestInteger(new int[]{3, 9, 2, 1, 7}, 3)); // 7
        System.out.println(s.largestInteger(new int[]{3, 9, 7, 2, 1, 7}, 4)); // 3
        System.out.println(s.largestInteger(new int[]{0, 0}, 1)); // -1
        System.out.println(s.largestInteger(new int[]{0, 0}, 2)); // 0

        System.out.println(s.largestIntegerBest(new int[]{3, 9, 2, 1, 7}, 3)); // 7
        System.out.println(s.largestIntegerBest(new int[]{3, 9, 7, 2, 1, 7}, 4)); // 3
        System.out.println(s.largestIntegerBest(new int[]{0, 0}, 1)); // -1
        System.out.println(s.largestIntegerBest(new int[]{0, 0}, 2)); // -1
    }
}
