package p14_longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        int lastIndex = strs[0].length();
        for (int i = 0; i < strs.length - 1; i++) {
            char[] first = strs[i].toCharArray();
            char[] second = strs[i + 1].toCharArray();
            int minLength = Math.min(first.length, second.length);
            if (minLength == 0) {
                return "";
            }
            if (minLength < lastIndex) lastIndex = minLength;
            for (int j = 0; j < minLength; j++) {
                if (first[j] != second[j] && lastIndex > j) lastIndex = j;
            }
        }

        return strs[0].substring(0, lastIndex);
    }

    public String longestCommonPrefixBest(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(arr));
        String[] arr1 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(arr1));
        String[] arr2 = {"ab", "a"};
        System.out.println(solution.longestCommonPrefix(arr2));

        System.out.println(solution.longestCommonPrefixBest(arr));
        System.out.println(solution.longestCommonPrefixBest(arr1));
        System.out.println(solution.longestCommonPrefixBest(arr2));
    }
}