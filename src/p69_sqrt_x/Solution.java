package p69_sqrt_x;

public class Solution {
    public int mySqrt(int x) {
        double x_ans, x_n = 1;
        while (true) {
            x_ans = (x_n + x / x_n) / 2;
            if ((int) x_ans == (int) x_n) return (int) x_ans;
            else x_n = x_ans;
        }
    }

    public int mySqrtBest(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;

            if (sq == x) return mid;
            else if (sq < x) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
        System.out.println(s.mySqrt(9));
        System.out.println(s.mySqrt(256));
        System.out.println(s.mySqrt(590));

        System.out.println(s.mySqrtBest(4));
        System.out.println(s.mySqrtBest(8));
        System.out.println(s.mySqrtBest(9));
        System.out.println(s.mySqrtBest(256));
        System.out.println(s.mySqrtBest(590));
    }
}
