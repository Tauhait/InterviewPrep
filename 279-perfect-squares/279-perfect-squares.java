class Solution {
    public int numSquares(int n) {
        Queue<Integer> perfectSqQueue = new LinkedList();
        Queue<Integer> intermediateN = new LinkedList();
        int sqrootN = (int)Math.sqrt(n);
        for(int i = 1; i <= sqrootN; i++){
            int squareOfI = i * i;
            perfectSqQueue.add(squareOfI);
        }
        intermediateN.offer(n); 
        int depth = 0;
        while(!intermediateN.isEmpty()){
            int size = intermediateN.size();  
            while(size-- > 0){
                Integer newN = intermediateN.poll();
                Iterator<Integer> perfectQIter = perfectSqQueue.iterator();
                while(perfectQIter.hasNext()){
                    Integer sq = perfectQIter.next();
                    //System.out.print(sq + " ");
                    if(newN.equals(sq)){
                        return depth + 1;
                    }else if(newN < sq){
                        break;
                    }else {
                        intermediateN.offer(newN - sq);
                    }                   
                }
                //System.out.println();
            }
            depth++;
        }
        return depth;
    }
}