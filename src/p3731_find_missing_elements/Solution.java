package p3731_find_missing_elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int s = nums[0], l = nums[0];
        for (int num : nums) {
            if (num < s) s = num;
            if (num > l) l = num;
            map.put(num, true);
        }
        for (int i = s + 1; i < l; i++) {
            if (!map.containsKey(i)) result.add(i);
        }
        return result;
    }

    public List<Integer> findMissingElementsFastest(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int max = nums[0];
        int min = nums[0];
        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int[] arr = new int[max + 1];
        for(int i : nums){
            arr[i]++;
        }

        for(int i=min;i<max;i++){
            if(arr[i] == 0)
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMissingElements(new int[]{1, 4, 2, 5}));
        System.out.println(s.findMissingElements(new int[]{7, 8, 6, 9}));
        System.out.println(s.findMissingElements(new int[]{5, 1}));

        System.out.println(s.findMissingElementsFastest(new int[]{1, 4, 2, 5}));
        System.out.println(s.findMissingElementsFastest(new int[]{7, 8, 6, 9}));
        System.out.println(s.findMissingElementsFastest(new int[]{5, 1}));
    }
}
