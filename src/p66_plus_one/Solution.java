package p66_plus_one;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int remainder = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + remainder < 10) {
                digits[i] = digits[i] + remainder;
                remainder = 0;
            } else {
                digits[i] = 0;
                remainder = 1;
            }
        }

        if (remainder == 0) return digits;
        else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
    }

    public int[] plusOneBest(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(s.plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));

        System.out.println(Arrays.toString(s.plusOneBest(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(s.plusOneBest(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(s.plusOneBest(new int[]{9})));
        System.out.println(Arrays.toString(s.plusOneBest(new int[]{9, 9})));
        System.out.println(Arrays.toString(s.plusOneBest(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(s.plusOneBest(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
