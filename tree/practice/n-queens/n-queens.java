class Solution {
    private Set<Integer> isSameColumn;
    private Set<Integer> isSameDiagonal;
    private Set<Integer> isSameAntiDiag;
    private List<List<String>> solutions;

    private List<String> buildSolution(char[][] board){
        List<String> solution = new ArrayList<>();
        for(char[] b : board){
            solution.add(new String(b));
        }
        return solution;
    }

    private void findSolution(int r, int n, char[][] board){
        if(r == n){
            solutions.add(buildSolution(board));
            return;
        }

        for(int c = 0; c < n; c++){
            int diagonal = r + c;
            int antiDiag = r - c;
            if( !isSameColumn.contains(c) && 
                !isSameDiagonal.contains(diagonal) && 
                !isSameAntiDiag.contains(antiDiag)){

                board[r][c] = 'Q';
                isSameColumn.add(c);
                isSameDiagonal.add(diagonal);
                isSameAntiDiag.add(antiDiag);

                findSolution(r + 1, n, board);

                //backtrack step
                isSameColumn.remove(c);
                isSameDiagonal.remove(diagonal);
                isSameAntiDiag.remove(antiDiag);
                board[r][c] = '.'; 
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        isSameColumn = new HashSet<>();
        isSameDiagonal = new HashSet<>();
        isSameAntiDiag = new HashSet<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
                
        findSolution(0, n, board);
        return solutions;
    }
}