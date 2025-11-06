package p58_length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0 && s.charAt(i) == ' ') continue;
            else if (length > 0 && s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
    }
}
