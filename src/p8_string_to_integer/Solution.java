package p8_string_to_integer;

public class Solution {
    public int myAtoi(String s) {
        int res = 0;
        boolean negative = false, started = false;

        for (char c : s.toCharArray()) {
            if (!started && (c == ' ' || c == '0')) continue;
            if (c != '-' && (c < '0' || c > '9') || (started && c == '-')) break;
            if (c == '-') {
                negative = true;
                continue;
            }

            if (!negative && (Integer.MAX_VALUE - res * 10 <= c - '0')) return Integer.MAX_VALUE;
            if (negative && (Integer.MAX_VALUE - res * 10 + 1 <= c - '0')) return Integer.MIN_VALUE;

            res = (c - '0') + res * 10;
            started = true;
        }

        return negative ? -1 * res : res;
    }
}
