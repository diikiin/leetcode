package p70_climbing_stairs;

public class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int f1 = 1, f2 = 1, fn = 0;
        for (int i = 0; i < n - 1; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(4));
        System.out.println(s.climbStairs(5));
        System.out.println(s.climbStairs(6));
        System.out.println(s.climbStairs(7));
    }
}
