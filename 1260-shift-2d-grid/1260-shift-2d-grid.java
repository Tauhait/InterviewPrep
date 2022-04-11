class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        k = k % (rows * cols);
        List<List<Integer>> shiftedGrid = new ArrayList<List<Integer>>(rows);
        for(int i = 0; i < rows; i++){
            shiftedGrid.add(i, new ArrayList<Integer>(cols));
            for(int j = 0; j < cols; j++){
                shiftedGrid.get(i).add(-1);
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int nexti = (j + k) / cols;
                int nextj = (j + k) % cols;
                if(i + nexti >= rows){
                    nexti = (i + nexti) % rows;
                    shiftedGrid.get(nexti).set(nextj, grid[i][j]);
                }else {
                    shiftedGrid.get(i + nexti).set(nextj, grid[i][j]);
                }                
            }
        }
        return shiftedGrid;
    }
}