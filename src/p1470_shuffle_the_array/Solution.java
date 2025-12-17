package p1470_shuffle_the_array;

import java.util.Arrays;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (n == 1) return nums;

        int temp;
        if (n == 2) {
            temp = nums[1];
            nums[1] = nums[2];
            nums[2] = temp;
            return nums;
        }

        int k = 1, l = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j < n; j++) {
                temp = nums[j];
                nums[j] = nums[j + l];
                nums[j + l] = temp;
            }
            k++;
            l--;
        }
        return nums;
    }

    public int[] shuffleWithONMemory(int[] nums, int n) {
        int[] ans = new int[n * 2];
        for (int i = 0, j = 0; i < n; i++, j += 2) {
            ans[j] = nums[i];
            ans[j + 1] = nums[i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(s.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(s.shuffle(new int[]{1, 1, 2, 2}, 2)));

        System.out.println(Arrays.toString(s.shuffleWithONMemory(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(s.shuffleWithONMemory(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        System.out.println(Arrays.toString(s.shuffleWithONMemory(new int[]{1, 1, 2, 2}, 2)));
    }
}
