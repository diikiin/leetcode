package p3289_the_two_sneaky_numbers_of_digitville;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int[] sneaky = new int[2];
        int index = 0;
        for (int num : nums) {
            if (!set.contains(num)) set.add(num);
            else {
                sneaky[index] = num;
                index++;
                if (index > 1) break;
            }
        }
        return sneaky;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.getSneakyNumbers(new int[]{0, 1, 1, 0})));
        System.out.println(Arrays.toString(s.getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2})));
        System.out.println(Arrays.toString(s.getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2})));
    }
}
