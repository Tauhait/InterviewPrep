class Solution {
    private int findOverlap(int[][] img1, int[][] img2, int shiftX, int shiftY, int n){
        int overlap = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int x = i+shiftX;
                int y = j+shiftY;
                if(x < 0 || x >= n || y < 0 || y >= n)
                    continue;
                if(img1[i][j] == 1 && img1[i][j] == img2[x][y])
                    overlap++;
            }
        }
        return overlap;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int largeOverlap = 0;
        for(int i = -n; i < n; i++){
            for(int j = -n; j < n; j++){
                largeOverlap = Math.max(largeOverlap, findOverlap(img1, img2, i, j, n));
            }
        }
        return largeOverlap;
    }
}