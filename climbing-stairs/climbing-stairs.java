class Solution {
    public int climbStairs(int n) {
        if(n <= 3)
            return n;
        int totalClimbs = 0;
        int climb2 = 2, climb3 = 3;
		for(int i=4; i <= n; i++) {
			totalClimbs = climb2 + climb3;
			climb2 = climb3;
			climb3 = totalClimbs;
		}
		return totalClimbs;        
    }
}