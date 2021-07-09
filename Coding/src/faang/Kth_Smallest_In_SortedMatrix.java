package faang;

public class Kth_Smallest_In_SortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length; 
        int cols = matrix[0].length; // For general, the matrix need not be a square
        int lo = matrix[0][0], hi = matrix[rows-1][cols-1], ans = -1;
        while (lo <= hi) {
            // int mid = (left + right) >> 1;
            int mid = lo + (hi - lo)/2;
            if (countLessOrEqual(matrix, mid, rows, cols) >= k) {
                ans = mid;
                hi = mid - 1; // try to looking for a smaller value in the left side
            } else lo = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }
    int countLessOrEqual(int[][] matrix, int x, int m, int n) {
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }

}
