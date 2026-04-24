package p67_add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String swap = a;
            a = b;
            b = swap;
        }

        String res = "";

        int n = b.length(), j = a.length() - 1;
        for (int i = n - 1; i >= 0; i++){
            if (a.charAt(j) != '1' && b.charAt(i) != '1') {

            }
        }
        return null;
    }
}
