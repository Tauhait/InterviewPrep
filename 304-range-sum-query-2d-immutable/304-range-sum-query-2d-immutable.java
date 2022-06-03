class NumMatrix {
    private int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSum = new int[rows + 1][cols + 1];
        
        int prefix = 0;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + 
                                          prefixSum[i][j + 1] + 
                                          matrix[i][j] - 
                                          prefixSum[i][j];
            }
        }
        
        // for(int[] mat: prefixSum){
        //     for(int m : mat){
        //         System.out.print(m +  "\t");
        //     }
        //     System.out.println();
        // }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.print(prefixSum[row2 + 1][col2 + 1] + " - ");
        // System.out.print(prefixSum[row1][col2 + 1] + " - ");
        // System.out.print(prefixSum[row2 + 1][col1] + " + ");
        // System.out.println(prefixSum[row1][col1]);
        
        return prefixSum[row2 + 1][col2 + 1] - 
                prefixSum[row1][col2 + 1] -
                prefixSum[row2 + 1][col1] +
                prefixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */