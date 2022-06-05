class Solution {
    public int totalNQueens(int n) {
        return backtrack(n, 0,  new HashSet<Integer>(), 
                                new HashSet<Integer>(), 
                                new HashSet<Integer>());
    }
    private int backtrack(int size, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags){
        if(row == size) return 1;
        
        int solutions = 0;
        for(int col = 0; col < size; col++){
            int diag = row - col;
            int antiDiag = row + col;
            
            if(cols.contains(col) || diags.contains(diag) || antiDiags.contains(antiDiag)) continue;
            
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);
            
            solutions += backtrack(size, row + 1, cols, diags, antiDiags);
            
            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);            
        }
        return solutions;
    }
}