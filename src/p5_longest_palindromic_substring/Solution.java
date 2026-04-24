package p5_longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        int index1 = -1, index2 = -1;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                index1 = -1;
                index2 = -1;
            } else if (i == j && index1 == -1) {
                j = s.length() - 1;
                i++;
            } else {
                if (index1 == -1) {
                    index1 = i;
                    index2 = j;
                }
                i++;
            }
            j--;
        }

        int index3 = -1, index4 = -1;
        int k = 0, l = s.length() - 1;
        while (k <= l) {
            if (s.charAt(k) != s.charAt(l)) {
                index3 = -1;
                index4 = -1;
            } else if (k == l && index3 == -1) {
                k = 0;
                l--;
            } else {
                if (index3 == -1) {
                    index3 = k;
                    index4 = l;
                }
                l--;
            }
            k++;
        }

        return index1 != -1 || index3 != -1 ? index2 - index1 > index4 - index3 ? s.substring(index1, index2 + 1)
                : s.substring(index3, index4 + 1) : s.substring(0, 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("ab"));
        System.out.println(s.longestPalindrome("abcde"));
        System.out.println(s.longestPalindrome("racecar"));
        System.out.println(s.longestPalindrome("abracadabra"));
        System.out.println(s.longestPalindrome("aaaaa"));
        System.out.println(s.longestPalindrome("ababa"));
        System.out.println(s.longestPalindrome("levelxyz"));
        System.out.println(s.longestPalindrome("xyzmadam"));
        System.out.println(s.longestPalindrome("Racecar"));
        System.out.println(s.longestPalindrome("1abba1"));
        System.out.println(s.longestPalindrome("abb"));
        System.out.println(s.longestPalindrome("baa"));
        System.out.println(s.longestPalindrome("bacabab"));
    }
}
