package p657_robot_return_to_origin;

public class Solution {
    public boolean judgeCircle(String moves) {
        short l = 0, r = 0, u = 0, d = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L' -> l++;
                case 'R' -> r++;
                case 'U' -> u++;
                case 'D' -> d++;
            }
        }

        return l == r && u == d;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.judgeCircle("UD"));
        System.out.println(s.judgeCircle("LL"));
    }
}
