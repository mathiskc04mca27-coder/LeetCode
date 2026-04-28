class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Look for an empty cell
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recurse to see if this choice leads to a solution
                            if (solve(board)) {
                                return true;
                            } else {
                                // Backtrack: undo the choice
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true; // All cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == num) return false;
            // Check column
            if (board[i][col] == num) return false;
            // Check 3x3 sub-box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }
}
