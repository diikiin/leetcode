package p67_add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String swap = a;
            a = b;
            b = swap;
        }

        StringBuilder res = new StringBuilder();
        boolean dyadic = false;

        int j = a.length() - 1;
        for (int i = b.length() - 1; i >= 0; i--, j--) {
            if (a.charAt(j) == '0' && b.charAt(i) == '0' && !dyadic) res.append('0');
            else if (a.charAt(j) == '0' && b.charAt(i) == '0' && dyadic) {
                res.append('1');
                dyadic = false;
            } else if (a.charAt(j) == '0' && b.charAt(i) == '1' && !dyadic) res.append('1');
            else if (a.charAt(j) == '0' && b.charAt(i) == '1' && dyadic) res.append('0');
            else if (a.charAt(j) == '1' && b.charAt(i) == '0' && !dyadic) res.append('1');
            else if (a.charAt(j) == '1' && b.charAt(i) == '0' && dyadic) res.append('0');
            else if (a.charAt(j) == '1' && b.charAt(i) == '1' && !dyadic) {
                res.append('0');
                dyadic = true;
            } else res.append('1');
        }

        if (!dyadic) return a.substring(0, j + 1) + res.reverse();

        for (; j >= 0; j--) {
            if (a.charAt(j) == '0' && !dyadic) res.append('0');
            else if (a.charAt(j) == '0' && dyadic) {
                res.append('1');
                dyadic = false;
            } else if (a.charAt(j) == '1' && !dyadic) res.append('1');
            else {
                res.append('0');
                dyadic = true;
            }
        }

        return dyadic ? "1" + res.reverse() : res.reverse().toString();
    }

    public String addBinaryBest(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            res.append(sum % 2);
            carry = sum / 2;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.addBinary("11", "1"));
        System.out.println(s.addBinary("1010", "1011"));
        System.out.println(s.addBinary("0", "0"));
        System.out.println(s.addBinary("1", "0"));
        System.out.println(s.addBinary("1", "1"));
        System.out.println(s.addBinary("111", "1"));
        System.out.println(s.addBinary("1111", "1111"));
        System.out.println(s.addBinary("101111", "10"));
        System.out.println(s.addBinary("1111111111111111", "1"));
        System.out.println(s.addBinary("1010101010101010", "101010101010101"));
        System.out.println(s.addBinary("0", "111111"));
        System.out.println(s.addBinary("111111", "0"));

        System.out.println("-------------------------");

        System.out.println(s.addBinaryBest("11", "1"));
        System.out.println(s.addBinaryBest("1010", "1011"));
        System.out.println(s.addBinaryBest("0", "0"));
        System.out.println(s.addBinaryBest("1", "0"));
        System.out.println(s.addBinaryBest("1", "1"));
        System.out.println(s.addBinaryBest("111", "1"));
        System.out.println(s.addBinaryBest("1111", "1111"));
        System.out.println(s.addBinaryBest("101111", "10"));
        System.out.println(s.addBinaryBest("1111111111111111", "1"));
        System.out.println(s.addBinaryBest("1010101010101010", "101010101010101"));
        System.out.println(s.addBinaryBest("0", "111111"));
        System.out.println(s.addBinaryBest("111111", "0"));
    }
}
