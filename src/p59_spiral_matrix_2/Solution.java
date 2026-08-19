package p59_spiral_matrix_2;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 1) return new int[][]{{1}};

        int[][] matrix = new int[n][n];
        int i = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = i++;
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = i++;
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    matrix[bottom][col] = i++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    matrix[row][left] = i++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.deepToString(s.generateMatrix(3))); // [[1,2,3],[8,9,4],[7,6,5]]
        System.out.println(Arrays.deepToString(s.generateMatrix(1))); // [[1]]
        System.out.println(Arrays.deepToString(s.generateMatrix(5))); // [[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]
        System.out.println(Arrays.deepToString(s.generateMatrix(4))); // [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
    }
}
