package p3_longest_substring;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            int repeatedChar = s.indexOf(s.charAt(right), left);
            if (repeatedChar != right) {
                left = repeatedChar + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
