class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        long result = 1;
        for(int i = 1; i < m; i++){
            result = result * (N-r+i)/i;
        }
        return (int)result;
    }
}