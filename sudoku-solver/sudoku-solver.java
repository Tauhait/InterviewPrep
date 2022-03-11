class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
     public boolean solve(char[][] board, int i, int j) {
        if(i == 9 && j == 0) {// last row, last col over || r: 0-8, c: 0-8
            return true;
        }
        int newRow = (j + 1) == 9? i + 1 : i;
        int newCol = (j + 1) == 9? 0 : j + 1;
        if(board[i][j] != '.') {
            return solve(board, newRow, newCol);
        }
        
        for(char num = '1'; num <= '9'; num++) {
            if(isValid(board, i, j, num)){
                board[i][j] = num;
                if(solve(board, newRow, newCol)){
                    return true;
                }
                board[i][j] = '.';
            }
        }        
        return false;        
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            int checkRow = 3*(row/3) + i / 3;
            int checkCol = 3*(col/3) + i % 3;
            if( (board[i][col] != '.' && board[i][col] == c) || 
                (board[row][i] != '.' && board[row][i] == c) ||
                (board[checkRow][checkCol] != '.' && 
                 board[checkRow][checkCol] == c)){
                return false;
            }
        }
        return true;
    }
}