package p12_integer_to_roman;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<Integer, String> INT_TO_ROMAN = new HashMap<>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int divider = 1000;
        while (divider > 0) {
            int digit = num / divider;
            if (digit > 0) {
                if (digit == 4 || digit == 9 || digit == 5) {
                    roman.append(INT_TO_ROMAN.get(digit * divider));
                } else if (digit > 5) {
                    roman.append(INT_TO_ROMAN.get(5 * divider));
                    for (int i = 0; i < digit - 5; i++) {
                        roman.append(INT_TO_ROMAN.get(divider));
                    }
                } else {
                    for (int i = 0; i < digit; i++) {
                        roman.append(INT_TO_ROMAN.get(divider));
                    }
                }
            }

            num %= divider;
            divider /= 10;
        }

        return roman.toString();
    }

    private static final int[] VALUES = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };

    private static final String[] SYMBOLS = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
    };

    public String intToRomanBest(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < VALUES.length; i++) {
            while (num >= VALUES[i]) {
                roman.append(SYMBOLS[i]);
                num -= VALUES[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.intToRoman(100));
        System.out.println(s.intToRoman(400));
        System.out.println(s.intToRoman(900));
        System.out.println(s.intToRoman(1000));
        System.out.println(s.intToRoman(1));
        System.out.println(s.intToRoman(11));
        System.out.println(s.intToRoman(111));
        System.out.println(s.intToRoman(1111));
        System.out.println(s.intToRoman(5));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(3749));
        System.out.println(s.intToRoman(3999));
        System.out.println(s.intToRoman(1994));

        System.out.println(s.intToRomanBest(100));
        System.out.println(s.intToRomanBest(400));
        System.out.println(s.intToRomanBest(900));
        System.out.println(s.intToRomanBest(1000));
        System.out.println(s.intToRomanBest(1));
        System.out.println(s.intToRomanBest(11));
        System.out.println(s.intToRomanBest(111));
        System.out.println(s.intToRomanBest(1111));
        System.out.println(s.intToRomanBest(5));
        System.out.println(s.intToRomanBest(58));
        System.out.println(s.intToRomanBest(3749));
        System.out.println(s.intToRomanBest(3999));
        System.out.println(s.intToRomanBest(1994));
    }
}
