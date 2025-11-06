package p119_pascals_triangle_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i < rowIndex + 1; i++) {
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

        return triangle.get(rowIndex);
    }

    public List<Integer> getRowBest(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getRow(0));
        System.out.println(s.getRow(1));
        System.out.println(s.getRow(2));
        System.out.println(s.getRow(3));
        System.out.println(s.getRow(4));

        System.out.println(s.getRowBest(0));
        System.out.println(s.getRowBest(1));
        System.out.println(s.getRowBest(2));
        System.out.println(s.getRowBest(3));
        System.out.println(s.getRowBest(4));
    }
}
