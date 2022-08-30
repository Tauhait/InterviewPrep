class Solution {
    public int heightChecker(int[] heights) {
        final int MAX_HEIGHT = 100;
        int[] freq = new int[MAX_HEIGHT+1];
        int count = 0;
        int currHeight = 1;
        
        for(int height : heights)
            freq[height]++;
        
        for(int height : heights){
            while(freq[currHeight] == 0) 
                currHeight++;            
            if(currHeight != height)
                    count++;
            freq[currHeight]--;
        }
        return count;
    }
}
