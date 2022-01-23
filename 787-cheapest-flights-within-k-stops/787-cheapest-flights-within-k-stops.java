class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst){
            return 0;
        }
        int[] previous = new int[n];
        int[] current = new int[n];
        for(int i = 0 ; i < n; i++){
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;
        
        for(int i = 0; i <= k; i++){
            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if(previous[from] < Integer.MAX_VALUE){//Means visited previously
                    current[to] = Math.min(previous[from] + price, current[to]);
                    //check if there is a better path already or a new low cost better path found 
                }
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE? -1 : current[dst];
    }
}