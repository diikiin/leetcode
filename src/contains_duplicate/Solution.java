package contains_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(s.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(s.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}