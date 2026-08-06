package p3345_smallest_divisible_digit_product_1;

public class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int p = 1, d = n;
            while (d > 0) {
                p *= d % 10;
                d /= 10;
            }

            if (p % t == 0) return n;
            n++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestNumber(10, 2));
        System.out.println(s.smallestNumber(15, 3));
        System.out.println(s.smallestNumber(9, 5));
        System.out.println(s.smallestNumber(1, 6));
    }
}
