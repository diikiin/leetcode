package p7_reverse_integer;

public class Solution {
    public int reverse(int x) {
        if ((x % 10 < -2 || x % 10 > 2) && x / 1000000000 != 0) return 0;
        int res = 0;
        boolean isNegative = x < 0;
        while (x != 0) {
            res = x % 10 + res * 10;
            x /= 10;
        }
        return isNegative && res < 0 || !isNegative && res > 0 ? res : 0;
    }

    public int reverseBest(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 ||
                    (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 ||
                    (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverse(-2147483648));
        System.out.println(s.reverse(2147483647));
        System.out.println(s.reverse(-214748364));
        System.out.println(s.reverse(214748364));
        System.out.println(s.reverse(-21474836));
        System.out.println(s.reverse(21474836));
        System.out.println(s.reverse(-2147447412));
        System.out.println(s.reverse(2147447412));
        System.out.println(s.reverse(-1147447412));
        System.out.println(s.reverse(1147447412));

        System.out.println(s.reverseBest(-2147483648));
        System.out.println(s.reverseBest(2147483647));
        System.out.println(s.reverseBest(-214748364));
        System.out.println(s.reverseBest(214748364));
        System.out.println(s.reverseBest(-21474836));
        System.out.println(s.reverseBest(21474836));
        System.out.println(s.reverseBest(-2147447412));
        System.out.println(s.reverseBest(2147447412));
        System.out.println(s.reverseBest(-1147447412));
        System.out.println(s.reverseBest(1147447412));
    }
}
