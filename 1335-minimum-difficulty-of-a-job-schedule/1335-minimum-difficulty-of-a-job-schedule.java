class Solution {
    private int[] jobDifficulty;
    private int n;
    private int d;
    private int[] hardestJobRemaining;
    private int[][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        if(d > n){
            return -1;
        }
        hardestJobRemaining = new int[n];
        int hardest = 0;
        for(int i = n - 1; i >= 0; i--){
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestJobRemaining[i] = hardest;
        }
        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 1);        
    }
    private int dp(int i, int day){
        if(day == d){
            return hardestJobRemaining[i];
        }
        if(memo[i][day] == -1){            
            int jobPossibilities = n - (d - day);
            int maxDifficulty = 0;
            int best = Integer.MAX_VALUE;
            for(int j = i; j < jobPossibilities; j++){
                maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]);
                best = Math.min(best, maxDifficulty + dp(j + 1, day + 1));             
            }
            memo[i][day] = best;
        }
        return memo[i][day];
    }
}