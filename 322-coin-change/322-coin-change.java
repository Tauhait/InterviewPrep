class Solution {
    private Map<Integer, Integer> memo;
    private int[] coins;
    
    private int dp(int money){
        // if(money < 0){
        //     return -1;
        // }
        if(money == 0){ 
            return 0;
        }
        int minCoins = Integer.MAX_VALUE;
        if(!memo.containsKey(money)){            
            for(int coin : coins){
                if(money - coin < 0){
                    continue;
                }
                int res = dp(money - coin);
                if(res >= 0 && res < minCoins){
                    minCoins = 1 + res;
                }    
            }    
            memo.put(money, minCoins == Integer.MAX_VALUE ? -1 : minCoins);               
        }
        return memo.get(money);
    }
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        memo = new HashMap<Integer, Integer>();
        this.coins = coins;
        return dp(amount);
    }
}