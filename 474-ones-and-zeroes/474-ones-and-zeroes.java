public class Solution {
    private Integer[][][] memo;
    
    public int calculate(String[] strs, int i, int zeroes, int ones) {
        if (i == strs.length)
            return 0;
        if (memo[i][zeroes][ones] != null)
            return memo[i][zeroes][ones];
        
        int[] count = countzeroesones(strs[i]);
        int taken = -1;
        if (zeroes - count[0] >= 0 && ones - count[1] >= 0)
            taken = 1 + calculate(strs, i + 1, zeroes - count[0], ones - count[1]);
        int not_taken = 0 + calculate(strs, i + 1, zeroes, ones);
        memo[i][zeroes][ones] = Math.max(taken, not_taken);
        return memo[i][zeroes][ones];
    }
    public int[] countzeroesones(String s) {//given a string, return #0s and #1s.
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - '0']++;
        }
        return c;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new Integer[strs.length][m + 1][n + 1];
        int ans = calculate(strs, 0, m, n);
        // // return ;
        // for(int i = 0; i < strs.length; i++){
        //     for(int j = 0; j < m; j++){
        //         for(int k = 0; k < n; k++){
        //             System.out.print(memo[i][j][k] + "\t");
        //         }
        //         System.out.println();
        //     }
        // }
        return ans;
    }
    
}

