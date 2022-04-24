class Solution {
    public int countLatticePoints(int[][] circles) {
    HashSet<String> res = new HashSet<String>(); // avoid duplicate points
    int count = 0;
    for(int[] arr : circles){
        int x = arr[0], y = arr[1], r = arr[2];  // center: (x,y) radius: r
        for(int i = x - r; i <= x + r; i++) { // generate integers for x-values in range [x-r, x+r]
            for(int j = y - r; j <= y + r; j++) { // generate integers for y-values in range [y-r, y+r]
                if((x - i)*(x - i) + (y - j)*(y - j) <= r*r) {
                    // circle equation: (x2-x1)^2 + (y2-y1)^2 = r^2
                    res.add(i+","+j);  // add current co-ordinate to hashset
                }
            }  
        }
    }
    return res.size();  // number of values in res is the answer
}
/**
Optimizations:

we only need to find the extreme points, this will avoid checking the points which are in between and are obviously inside the circle.
only find points on one half of the circle and multiply the number by two, since it's a circle there will be same amount of points on the other side. (except for the points on the dead center).
*/
}