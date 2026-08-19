package p54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int len = matrix.length * matrix[0].length;
        int x = 0, y = 0;
        int ax = 0, bx = matrix[0].length - 1, ay = 0, by = matrix.length - 1;
        Direction direction = Direction.RIGHT;

        for (int i = 0; i < len; i++) {
            res.add(matrix[y][x]);
            switch (direction) {
                case RIGHT -> {
                    if (x != bx) {
                        x++;
                    } else {
                        y++;
                        ay++;
                        direction = Direction.DOWN;
                    }
                }
                case DOWN -> {
                    if (y != by) {
                        y++;
                    } else {
                        x--;
                        bx--;
                        direction = Direction.LEFT;
                    }
                }
                case LEFT -> {
                    if (x != ax) {
                        x--;
                    } else {
                        y--;
                        by--;
                        direction = Direction.UP;
                    }
                }
                case UP -> {
                    if (y != ay) {
                        y--;
                    } else {
                        x++;
                        ax++;
                        direction = Direction.RIGHT;
                    }
                }
            }
        }

        return res;
    }

    enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public List<Integer> spiralOrderBest(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); //[1,2,3,6,9,8,7,4,5]
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})); //[1,2,3,4,8,12,11,10,9,5,6,7]

        System.out.println(s.spiralOrderBest(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); //[1,2,3,6,9,8,7,4,5]
        System.out.println(s.spiralOrderBest(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})); //[1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
