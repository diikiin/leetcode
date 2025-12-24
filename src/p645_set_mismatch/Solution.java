package p645_set_mismatch;

import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        mergeSort(nums, n);
        if (nums[0] != 1) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    res[0] = nums[i];
                }
            }
            res[1] = 1;
            return res;
        }
        if (nums[n - 1] != n) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    res[0] = nums[i];
                }
            }
            res[1] = n;
            return res;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res[0] = nums[i];
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != j) {
                        res[1] = j;
                        break;
                    }
                }
                break;
            } else if (nums[i] + 2 == nums[i + 1] && nums[i + 1] != nums[i + 2]) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (nums[j] == nums[j + 1]) {
                        res[0] = nums[j];
                        break;
                    }
                }
                res[1] = nums[i] + 1;
                break;
            }
        }
        return res;
    }

    private static void mergeSort(int[] nums, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = nums[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(nums, left, right, mid, n - mid);
    }

    private static void merge(int[] nums, int[] left, int[] right, int leftIndex, int rightIndex) {
        int i = 0, j = 0, k = 0;
        while (i < leftIndex && j < rightIndex) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }
        while (i < leftIndex) {
            nums[k++] = left[i++];
        }
        while (j < rightIndex) {
            nums[k++] = right[j++];
        }
    }

    public int[] findErrorNumsBest(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{4, 3, 3, 1})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{5, 3, 6, 1, 5, 4, 7, 8})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{37, 62, 43, 27, 12, 66, 36, 18, 39, 54, 61, 65, 47, 32, 23, 2, 46, 8, 4, 24, 29, 38, 63, 39, 25, 11, 45, 28, 44, 52, 15, 30, 21, 7, 57, 49, 1, 59, 58, 14, 9, 40, 3, 42, 56, 31, 20, 41, 22, 50, 13, 33, 6, 10, 16, 64, 53, 51, 19, 17, 48, 26, 34, 60, 35, 5})));

        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{1, 1})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{4, 3, 3, 1})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{3, 2, 3, 4, 6, 5})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{5, 3, 6, 1, 5, 4, 7, 8})));
        System.out.println(Arrays.toString(s.findErrorNumsBest(new int[]{37, 62, 43, 27, 12, 66, 36, 18, 39, 54, 61, 65, 47, 32, 23, 2, 46, 8, 4, 24, 29, 38, 63, 39, 25, 11, 45, 28, 44, 52, 15, 30, 21, 7, 57, 49, 1, 59, 58, 14, 9, 40, 3, 42, 56, 31, 20, 41, 22, 50, 13, 33, 6, 10, 16, 64, 53, 51, 19, 17, 48, 26, 34, 60, 35, 5})));
    }
}
