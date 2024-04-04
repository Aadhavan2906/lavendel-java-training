import java.util.HashSet;
import java.util.Set;

class SudokuValidator {
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        boolean valid = isValidSudoku(board);
        System.out.println(valid); // Output: true
    }

    private static boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            Set<Integer> box = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                if (val != 0) {
                    if (!row.add(val)) {
                        return false;
                    }
                }
                val = board[j][i];
                if (val != 0) {
                    if (!col.add(val)) {
                        return false;
                    }
                }
                int boxRow = (i / 3) * 3 + j / 3;
                int boxCol = (i % 3) * 3 + j % 3;
                val = board[boxRow][boxCol];
                if (val != 0) {
                    if (!box.add(val)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}