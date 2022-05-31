class Solution {    
    public int shipWithinDays(int[] weights, int days) {
        int ans = -1;
        int low = Integer.MIN_VALUE;        
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        
        while(low <= high){
            int mid = (low + high) >> 1;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] weights, int days, int barrier){
        int d = 1;
        int currLoad = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] > barrier) return false;
            else if(currLoad + weights[i] > barrier){
                d++;
                currLoad = weights[i];
            }else {
                currLoad += weights[i];
            }
        }
        return d <= days;
    }
}