/*
def backtrack_nqueen(row = 0, count = 0):
    for col in range(n):
        # iterate through columns at the curent row.
        if is_not_under_attack(row, col):
            # explore this partial candidate solution, and mark the attacking zone
            place_queen(row, col)
            if row + 1 == n:
                # we reach the bottom, i.e. we find a solution!
                count += 1
            else:
                # we move on to the next row
                count = backtrack_nqueen(row + 1, count)
            # backtrack, i.e. remove the queen and remove the attacking zone.
            remove_queen(row, col)
    return count
*/

class Solution {
    private int count = 0;
    private LinkedList<Integer> rows = new LinkedList<Integer>();
    private LinkedList<Integer> cols = new LinkedList<Integer>();
    public int totalNQueens(int n) {
        backtrackNQueens(n, 0);
        return count;
    }
    private void backtrackNQueens(int n, int row){
        for(int col = 0; col < n; col++){
            if(isNotUnderAttack(row, col)){
                placeQueen(row, col);
                if(row + 1 == n){
                    count++;
                }else {
                    backtrackNQueens(n, row + 1);
                }
                removeQueen(row, col);
            }
        }        
    }
    private void removeQueen(int row, int col){
        rows.pollLast();
        cols.pollLast();
    }
    private void placeQueen(int row, int col){
        rows.add(row);
        cols.add(col);
    }
    private boolean isNotUnderAttack(int row, int col){
        if(rows.contains(row) || cols.contains(col)){
            return false;
        }
        int size = rows.size();
        for(int index = 0; index < size; index++){
            int r = rows.get(index);
            int c = cols.get(index);
            if(Math.abs(row - r) == Math.abs(col - c)){
                return false;
            }
        }
        return true;               
    }
}