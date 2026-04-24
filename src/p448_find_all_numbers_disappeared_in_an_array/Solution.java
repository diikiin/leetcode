package p448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == 1 ? Collections.singletonList(2) : Collections.singletonList(1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(nums.length - Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{1, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{2, 2}));
        System.out.println(s.findDisappearedNumbers(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.findDisappearedNumbers(new int[]{2, 2, 2, 2}));
        System.out.println(s.findDisappearedNumbers(new int[]{1}));
        System.out.println(s.findDisappearedNumbers(new int[]{2, 3, 3, 4}));
        System.out.println(s.findDisappearedNumbers(new int[]{1, 1, 1, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6}));
        System.out.println(s.findDisappearedNumbers(new int[]{5, 4, 3, 2, 1}));
        System.out.println(s.findDisappearedNumbers(new int[]{1, 1, 3, 3, 5, 5}));
    }
}
