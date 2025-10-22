package p28_find_the_index_of_the_first_occurence_in_a_string;

public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] charsNeedle = needle.toCharArray();
        if (chars.length < charsNeedle.length) return -1;

        int index = -1, count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (count == charsNeedle.length) return index;
            if (chars[i] == charsNeedle[count] && index == -1) {
                index = i;
                count++;
            } else if (chars[i] == charsNeedle[count]) {
                count++;
            } else {
                i -= count;
                index = -1;
                count = 0;
            }
        }

        return count == charsNeedle.length ? index : -1;
    }

    public int strStrBest(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));

        System.out.println(solution.strStr2("sadbutsad", "sad"));
        System.out.println(solution.strStr2("leetcode", "leeto"));
        System.out.println(solution.strStr2("a", "a"));
        System.out.println(solution.strStr2("aaa", "aaaa"));
        System.out.println(solution.strStr2("mississippi", "issip"));
        System.out.println(solution.strStr2("mississippi", "issipi"));

        System.out.println(solution.strStrBest("sadbutsad", "sad"));
        System.out.println(solution.strStrBest("leetcode", "leeto"));
        System.out.println(solution.strStrBest("a", "a"));
        System.out.println(solution.strStrBest("aaa", "aaaa"));
        System.out.println(solution.strStrBest("mississippi", "issip"));
        System.out.println(solution.strStrBest("mississippi", "issipi"));
    }
}
