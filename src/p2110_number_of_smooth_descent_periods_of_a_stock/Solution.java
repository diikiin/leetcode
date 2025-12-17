package p2110_number_of_smooth_descent_periods_of_a_stock;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = prices.length;
        long streak = 0;
        for (int i = 1; i <= prices.length; i++) {
            if (i < prices.length && prices[i - 1] - prices[i] == 1) streak++;
            else {
                res += (streak * (streak + 1)) / 2;
                streak = 0;
            }
        }
        return res;
    }

    public long getDescentPeriodsBest(int[] prices) {
        long res = 1;
        int prev = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) prev++;
            else prev = 1;
            res += prev;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getDescentPeriods(new int[]{3, 2, 1, 4}));
        System.out.println(s.getDescentPeriods(new int[]{8, 6, 7, 7}));
        System.out.println(s.getDescentPeriods(new int[]{1}));
        System.out.println(s.getDescentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7}));

        System.out.println(s.getDescentPeriodsBest(new int[]{3, 2, 1, 4}));
        System.out.println(s.getDescentPeriodsBest(new int[]{8, 6, 7, 7}));
        System.out.println(s.getDescentPeriodsBest(new int[]{1}));
        System.out.println(s.getDescentPeriodsBest(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7}));
    }
}
