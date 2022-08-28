class Solution {
    public int[][] diagonalSort(int[][] mat) {
        ArrayList<Integer> diagonals;
        int rows = mat.length;
        int cols = mat[0].length;
        
        for(int i = 0; i < rows; i++){
            diagonals = new ArrayList<Integer>();
            for(int j = 0, k = i; k < rows && j < cols; j++, k++){
                diagonals.add(mat[k][j]);
            }
            Collections.sort(diagonals);
            int size = diagonals.size();
            for(int j = 0, k = i, l = 0; l < size && k < rows && j < cols; l++, j++, k++){
                mat[k][j] = diagonals.get(l);
            }
        }
        for(int j = 1; j < cols; j++){
            diagonals = new ArrayList<Integer>();
            for(int i = 0, k = j; k < cols && i < rows; i++, k++){
                diagonals.add(mat[i][k]);
            }
            Collections.sort(diagonals);
            int size = diagonals.size();
            for(int i = 0, k = j, l = 0; l < size && k < cols && i < rows; l++, i++, k++){
                mat[i][k] = diagonals.get(l);
            }
        }
        return mat;
    }
    //Time complexity = O(n*n)
    //Space complexity = O(n)
}