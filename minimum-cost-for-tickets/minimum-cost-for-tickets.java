class Solution {
    private int[] costs;
    private Integer[] memo;
    private Set<Integer> dayset;//contains the days I'm travelling

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) {
            dayset.add(d);
        }
        return dp(365);
    }

    private int dp(int i) {
        if (i < 1){ 
            return 0;
        }
        if (memo[i] != null){ 
            return memo[i];
        }
        if (dayset.contains(i)) {
            //if I'm travelling on ith day then find the minimum cost using 1-, 7-, and 
            //30- day pass variants
            memo[i] = Math.min(dp(i - 1) + costs[0],
                               Math.min(dp(i - 7) + costs[1], dp(i - 30) + costs[2]));
        } else {//not trvalling on ith day, skip
            memo[i] = dp(i - 1);
        }
        return memo[i];
    }
    
}