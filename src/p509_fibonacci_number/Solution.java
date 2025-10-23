package p509_fibonacci_number;

public class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib[n];
    }

    public int fib1(int n) {
        if (n == 0 || n == 1) return n;
        int f0 = 0, f1 = 1;
        int fn = 0;
        for (int i = 2; i < n + 1; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(2));
        System.out.println(s.fib(3));
        System.out.println(s.fib(4));
    }
}
