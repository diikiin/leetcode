package p13_roman_to_integer;

import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int lastIndex = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if ('M' == s.charAt(i)) {
                num += 1000;
            } else if ('D' == s.charAt(i)) {
                num += 500;
            } else if ('C' == s.charAt(i)) {
                if (i != lastIndex && 'M' == s.charAt(i + 1)) {
                    num += 900;
                    i++;
                } else if (i != lastIndex && 'D' == s.charAt(i + 1)) {
                    num += 400;
                    i++;
                } else num += 100;
            } else if ('L' == s.charAt(i)) {
                num += 50;
            } else if ('X' == s.charAt(i)) {
                if (i != lastIndex && 'C' == s.charAt(i + 1)) {
                    num += 90;
                    i++;
                } else if (i != lastIndex && 'L' == s.charAt(i + 1)) {
                    num += 40;
                    i++;
                } else num += 10;
            } else if ('V' == s.charAt(i)) {
                num += 5;
            } else {
                if (i != lastIndex && 'X' == s.charAt(i + 1)) {
                    num += 9;
                    i++;
                } else if (i != lastIndex && 'V' == s.charAt(i + 1)) {
                    num += 4;
                    i++;
                } else num++;
            }
        }

        return num;
    }

    private static final Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToIntBest(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));

        System.out.println(solution.romanToIntBest("III"));
        System.out.println(solution.romanToIntBest("LVIII"));
        System.out.println(solution.romanToIntBest("MCMXCIV"));
    }
}
