class Solution {
    public int numSquares(int n) {
        Queue<Integer> perfectSqQueue = new LinkedList();
        Queue<Integer> intermediateN = new LinkedList();
        int sqRootOfN = (int) Math.sqrt(n);
        for(int i = 1; i <= sqRootOfN; i++){
            int squareOfI = i * i;
            perfectSqQueue.offer(squareOfI);
        }
        intermediateN.offer(n);
        int perfectSqN = perfectSqQueue.size(); 
        int depth = 0;
        while(!intermediateN.isEmpty()){
            int size = intermediateN.size();
            while(size-- > 0){
                int newN = intermediateN.poll();
                for(int sq = 1; sq <= perfectSqN; sq++){
                    int perfectSq = perfectSqQueue.poll();
                    perfectSqQueue.offer(perfectSq);
                    if(newN - perfectSq == 0){
                        return depth + 1;
                    }
                    if(perfectSq < newN){
                        intermediateN.offer(newN - perfectSq);
                    }                    
                }                
            }
            depth++;
        }
        return -1;
    }
}