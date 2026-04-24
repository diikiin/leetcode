package p10_regular_expression_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (".*".equals(p)) return true;

//        int j = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (j >= p.length()) return false;
//            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
//                j++;
//            } else if (p.charAt(j) == '*' && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
//                while (i < s.length() && s.charAt(i) == p.charAt(j - 1)) {
//                    i++;
//                }
//                j++;
//            } else return false;
//        }
//
//        return s.length() >= p.length() || (s.length() + 1 == p.length() && p.charAt(p.length() - 1) == '*');

        int i = 0, j = 0;
        while (i < s.length() || j < p.length()) {
            if (i >= s.length()) {

            }
            if (j >= p.length()) return false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') j++;
            else if (p.charAt(j) == '*' && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                while (i < s.length() && s.charAt(i) == p.charAt(j - 1)) i++;
                j++;
            } else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isMatch("aa", "a"));                   //false
        System.out.println(s.isMatch("aa", "a*"));                  //true
        System.out.println(s.isMatch("aa", "a."));                  //true
        System.out.println(s.isMatch("ab", ".*"));                  //true
        System.out.println(s.isMatch("abc", "abc"));                //true
        System.out.println(s.isMatch("abc", "a.c"));                //true
        System.out.println(s.isMatch("abc", "abd"));                //false
        System.out.println(s.isMatch("ab", "ab*c"));                //false
        System.out.println(s.isMatch("aaab", "a*b"));               //true
        System.out.println(s.isMatch("ab", "a*b"));                 //true
        System.out.println(s.isMatch("abbbbc", "a.*c"));            //true
        System.out.println(s.isMatch("a", "*a"));                   //false
        System.out.println(s.isMatch("aab", "c*a*b"));              //true
        System.out.println(s.isMatch("mississippi", "mis*is*p*.")); //false
        System.out.println(s.isMatch("aaa", "ab*a*c*a"));           //true
        System.out.println(s.isMatch("aaaaaaaaab", "a*b"));         //true
        System.out.println(s.isMatch("ab", ".*c"));                 //false
        System.out.println(s.isMatch("xyzzza", "x.*z*a"));          //true
    }
}
