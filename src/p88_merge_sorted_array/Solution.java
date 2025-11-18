package p88_merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[length--] = nums2[j--];
            } else {
                nums1[length--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[length--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1, 2, 6, 0, 0, 0};
        s.merge(nums1, 3, new int[]{2, 3, 5}, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[]{4, 5, 6, 7, 0, 0, 0};
        s.merge(nums2, 4, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 2, 3, 0, 0, 0, 0};
        s.merge(nums3, 3, new int[]{0, 4, 5, 6}, 4);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = new int[]{1, 2, 3, 0, 0, 0};
        s.merge(nums4, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums4));

        int[] nums5 = new int[]{1};
        s.merge(nums5, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums5));

        int[] nums6 = new int[]{0};
        s.merge(nums6, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums6));
    }
}
