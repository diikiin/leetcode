package p561_array_partition;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int arrayPairSum(int[] nums) {
        TreeMap<Integer, Integer> numbers = new TreeMap<>();
        for (int num : nums) {
            if (numbers.containsKey(num)) numbers.put(num, numbers.get(num) + 1);
            else numbers.put(num, 1);
        }

        int max = 0, remain = 0;
        boolean hasRemain = false;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (!hasRemain && entry.getValue() % 2 == 0) {
                max += entry.getKey() * (entry.getValue() / 2);
            } else if (!hasRemain && entry.getValue() % 2 == 1) {
                max += entry.getKey() * (entry.getValue() / 2);
                remain = entry.getKey();
                hasRemain = true;
            } else if (hasRemain && entry.getValue() % 2 == 0) {
                max += remain + entry.getKey() * ((entry.getValue() - 1) / 2);
                remain = entry.getKey();
            } else if (hasRemain && entry.getValue() % 2 == 1) {
                max += remain + entry.getKey() * (entry.getValue() / 2);
                remain = 0;
                hasRemain = false;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(s.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
        System.out.println(s.arrayPairSum(new int[]{1, 2, 2, 5, 5, 6}));
    }
}
