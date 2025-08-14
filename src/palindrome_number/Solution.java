package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int start, end, digits = 0, length;
        int num = x;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        length = digits / 2;

        for (int i = 0; i < length; i++) {
            int power = (int) Math.pow(10, --digits);
            start = x / power;
            end = x % 10;
            if (start != end) return false;
            x %= power;
            x /= 10;
            digits--;
        }

        return true;
    }

    public boolean isPalindromeBest(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(-11));
        System.out.println(solution.isPalindrome(1000000));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(99989));
        System.out.println(solution.isPalindrome(99999));
        System.out.println(solution.isPalindrome(9999));
        System.out.println(solution.isPalindrome(1234554321));

    }
}
