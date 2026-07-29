package p96_unique_binary_search_trees;

import java.math.BigInteger;

public class Solution {
    public int numTrees(int n) {
        BigInteger nFactorial = BigInteger.ONE, n2Factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        for (int i = n + 2; i <= 2 * n; i++) {
            n2Factorial = n2Factorial.multiply(BigInteger.valueOf(i));
        }
        return n2Factorial.divide(nFactorial).intValue();
    }

    public int numTreesBest(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i / 2; j++) {
                dp[i] += 2 * dp[j] * dp[i - j - 1];
            }
            if (i % 2 == 1) {
                dp[i] += dp[i / 2] * dp[i / 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTreesBest(1));
        System.out.println(s.numTreesBest(2));
        System.out.println(s.numTreesBest(3));
        System.out.println(s.numTreesBest(4));
        System.out.println(s.numTreesBest(5));
        System.out.println(s.numTreesBest(19));
    }
}
