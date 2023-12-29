package median_of_sorted_arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        double result = -1;
        int medIndex1 = -1, medIndex2 = -1;
        if ((m + n) % 2 == 0) {
            medIndex2 = (m + n) / 2;
            medIndex1 = medIndex2 - 1;
        } else {
            medIndex1 = (m + n - 1) / 2;
        }



        return result;
    }
}
