package p4_median_of_sorted_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int full = m + n, half = full / 2, leftPartition = 0;
        if (m < n) {
            int left = 0, right = m - 1;
        } else {
            int left = 0, right = n - 1;
        }
        int left1 = 0, right1 = nums1.length - 1, left2 = 0, right2 = nums2.length - 1;
        while (left1 <= right1) {
            while (left2 <= right2) {
                int mid = (left2 + right2) / 2;
                leftPartition = half - mid;
                if (nums2[mid] <= nums1[leftPartition]) {
                    if (mid != nums2.length - 1)
                    if (nums1[leftPartition - 1] <= nums2[mid + 1]) {
                        if (full % 2 == 1) {
                            return Math.min(nums1[leftPartition], nums2[mid + 1]);
                        } else {
                            return Math.max(nums1[leftPartition - 1], nums2[mid]) + Math.min(nums1[leftPartition], nums2[mid + 1]);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
