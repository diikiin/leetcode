package p36_valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] section = new boolean[9];
        for (char[] row : board) {
            for (int j = 0; j < section.length; j++) {
                section[j] = false;
            }
            for (int k = 0; k < board[0].length; k++) {
                if (row[k] == '.') continue;
                if (section[row[k] - '1']) return false;
                else section[row[k] - '1'] = true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < section.length; j++) {
                section[j] = false;
            }
            for (char[] row : board) {
                if (row[i] == '.') continue;
                if (section[row[i] - '1']) return false;
                else section[row[i] - '1'] = true;
            }
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                for (int k = 0; k < section.length; k++) {
                    section[k] = false;
                }
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[i + m][j + n] == '.') continue;
                        if (section[board[i + m][j + n] - '1']) return false;
                        else section[board[i + m][j + n] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudokuBest(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int numIndex = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;
                if (rows[i][numIndex] || cols[j][numIndex] || boxes[boxIndex][numIndex]) return false;
                rows[i][numIndex] = cols[j][numIndex] = boxes[boxIndex][numIndex] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // true

        System.out.println(s.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // false

        System.out.println(s.isValidSudokuBest(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // true

        System.out.println(s.isValidSudokuBest(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // false
    }
}
