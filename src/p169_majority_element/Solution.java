package p169_majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        System.out.println(s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
