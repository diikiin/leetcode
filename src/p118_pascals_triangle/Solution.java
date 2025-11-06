package p118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> prev = new ArrayList<>(1);
        prev.add(1);
        res.add(prev);

        if (numRows == 1) {
            return res;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> elem = new ArrayList<>(i);
            elem.add(1);
            for (int j = 1; j < prev.size(); j++) {
                elem.add(prev.get(j - 1) + prev.get(j));
            }
            elem.add(1);
            prev = elem;
            res.add(elem);
        }

        return res;
    }

    public List<List<Integer>> generateBest(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else {
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.generate(1));
        System.out.println(s.generate(2));
        System.out.println(s.generate(3));
        System.out.println(s.generate(4));
        System.out.println(s.generate(5));

        System.out.println(s.generateBest(1));
        System.out.println(s.generateBest(2));
        System.out.println(s.generateBest(3));
        System.out.println(s.generateBest(4));
        System.out.println(s.generateBest(5));
    }
}
