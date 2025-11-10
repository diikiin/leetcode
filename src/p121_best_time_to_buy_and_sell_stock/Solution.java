package p121_best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
                continue;
            }
            int profit = prices[i] - minPrice;
            if (maxProfit < profit) maxProfit = profit;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
