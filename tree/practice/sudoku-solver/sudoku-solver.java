class Solution {
    private boolean solve(char[][] board, int r, int c){
        if(r == 9) return true;

        int newR = (c + 1 == 9) ? r + 1 : r;
        int newC = (c + 1 == 9) ? 0 : c + 1;

        if(board[r][c] != '.') return solve(board, newR, newC);
        else {
            for(char digit = '1'; digit <= '9'; digit++){
                if(isValid(board, digit, r, c)) { 
                    board[r][c] = digit;
                    if(solve(board, newR, newC)) return true;
                    board[r][c] = '.';
                }
            }
            return false;
        }
    }

    private boolean isValid(char[][] board, char digit, int r, int c){
        for(int i = 0; i < 9; i++){
            int subBoxRow = i / 3;
            int boxRow = 3 * (r / 3);
            int exactSubBoxRow = boxRow + subBoxRow;

            int subBoxCol = i % 3;
            int boxCol = 3 * (c / 3);
            int exactSubBoxCol =  boxCol + subBoxCol;

            if( (board[i][c] != '.' && board[i][c] == digit) || 
                (board[r][i] != '.' && board[r][i] == digit) ||
                (board[exactSubBoxRow][exactSubBoxCol] != '.' 
                    && board[exactSubBoxRow][exactSubBoxCol] == digit))
                return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);        
    }
}