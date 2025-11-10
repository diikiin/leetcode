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

    public int arrayPairSumBest(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(s.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
        System.out.println(s.arrayPairSum(new int[]{1, 2, 2, 5, 5, 6}));

        System.out.println(s.arrayPairSumBest(new int[]{1, 4, 3, 2}));
        System.out.println(s.arrayPairSumBest(new int[]{6, 2, 6, 5, 1, 2}));
        System.out.println(s.arrayPairSumBest(new int[]{1, 2, 2, 5, 5, 6}));
    }
}
