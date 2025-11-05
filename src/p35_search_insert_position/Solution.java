package p35_search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
                index = left;
            } else {
                right = mid - 1;
                index = mid;
            }
        }

        return Math.max(index, 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1, 3}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
