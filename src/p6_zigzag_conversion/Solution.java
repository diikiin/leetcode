package p6_zigzag_conversion;

public class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;

        int jump;
        boolean down = true;
        int cursor = 0, row = 0;
        StringBuilder res = new StringBuilder(s.length());
        res.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (row > 0 && row < numRows - 1) {
                jump = down ? (numRows - 1 - row) * 2 : row * 2;
                down = !down;
            } else {
                jump = (numRows - 1) * 2;
            }

            if (cursor + jump < s.length()) {
                res.append(s.charAt(cursor + jump));
                cursor += jump;
            } else {
                cursor = ++row;
                res.append(s.charAt(cursor));
                down = row != numRows - 1;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 4));
        System.out.println(s.convert("A", 1));
        System.out.println(s.convert("AB", 1));
    }
}
