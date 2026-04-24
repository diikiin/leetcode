package p2833_furthest_point_from_origin;

public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        byte l = 0, r = 0, u = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') l++;
            else if (c == 'R') r++;
            else if (c == '_') u++;
        }

        if (l >= r) return l - r + u;
        else return r - l + u;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(s.furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(s.furthestDistanceFromOrigin("_______"));
    }
}
