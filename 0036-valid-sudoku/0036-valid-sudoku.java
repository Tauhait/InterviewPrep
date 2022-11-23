class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<String> seen = new HashSet<String>();
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        // for(String s : seen) System.out.println(s);
        return true;
    }
}