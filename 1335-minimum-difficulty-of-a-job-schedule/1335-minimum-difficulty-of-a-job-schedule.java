class Solution {
    private int[] jobDifficulty;
    private Integer[][] memo;
    
    private int dp(int idx, int daysRemain){
        if(memo[idx][daysRemain] != null)
            return memo[idx][daysRemain];
        if(daysRemain == 1){
            int difficulty = 0;
            for(int i = idx; i < jobDifficulty.length; i++){
                difficulty = Math.max(difficulty, jobDifficulty[i]);
            }
            return difficulty;
        }
        int minJobDifficulty = Integer.MAX_VALUE;
        int dailyMaxJobDifficulty = 0;
        for(int i = idx; i < jobDifficulty.length-daysRemain+1; i++){
            dailyMaxJobDifficulty = Math.max(dailyMaxJobDifficulty, jobDifficulty[i]);
            minJobDifficulty = Math.min(minJobDifficulty, 
                                        dailyMaxJobDifficulty + dp(i+1, daysRemain-1));
        }
        return memo[idx][daysRemain] = minJobDifficulty;
    }
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d)
            return -1;
        memo = new Integer[n][d+1];
        this.jobDifficulty = jobDifficulty;
        return dp(0, d);
    }
}