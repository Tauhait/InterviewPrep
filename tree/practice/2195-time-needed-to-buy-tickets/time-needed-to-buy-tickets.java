class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sub = tickets[k];
        int total = 0;
        
        for(int i = 0; i < tickets.length; i++) {
            if(i <= k) total += Math.min(sub,tickets[i]);
            else total += Math.min(sub - 1, tickets[i]);
        }
        return total;
        
    }
}