package faang;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {        
        int rows = matrix.length;
        if(rows == 0) return new ArrayList<Integer>();
        int cols = matrix[0].length;
        List<Integer> res = new ArrayList<Integer>();
        int elems = 1;
        int n = rows * cols;
        int iter = 0;
        while(elems < n){
            //top
            for(int i = iter; elems <= n && i < cols - iter - 1; i++){
                res.add(matrix[iter][i]);
                ++elems;
            }
            //right
            for(int i = iter; elems <= n && i < rows - iter - 1; i++){
                res.add(matrix[i][cols - 1 - iter]);
                ++elems;
            }
            //bottom
            for(int i = cols - 1 - iter; elems <= n && i > iter; i--){
                res.add(matrix[rows - 1 - iter][i]);
                ++elems;
            }
            //left
            for(int i = rows - 1 - iter; elems <= n && i > iter; i--){
                res.add(matrix[i][iter]);
                ++elems;
            }
            ++iter;
        }
        /* Special case when n is a perfect square. */
        if(rows > 0 && rows == cols && rows % 2 == 1) res.add(matrix[rows/2][rows/2]);
        return res;
    }
}
