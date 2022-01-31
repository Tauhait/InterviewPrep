class Solution {
    /*
    * Since BFS guarantees that we search all rooms of distance d before searching rooms of distance d + 1, 
    * the distance to an empty room must be the shortest.
    */
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<Pair<Integer, Integer>> gatesQ = new LinkedList();
        int rows = rooms.length;
        int cols = rooms[0].length;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(rooms[row][col] == 0){
                    gatesQ.add(new Pair<Integer, Integer>(row, col));
                }
            }
        }
        //int size = gatesQ.size();
        //System.out.println(size);
        //while(size-- > 0){
        while(!gatesQ.isEmpty()){ 
           Pair<Integer, Integer> gate = gatesQ.poll();
           //Deque<Pair<Integer, Integer>> traverseQ = new LinkedList();
           //traverseQ.offer(gate);
           //int level = 1;
           //Set<Pair<Integer, Integer>> isVisited = new HashSet();
           
           //while(!traverseQ.isEmpty()){
             //  int levelSize = traverseQ.size();
              // while(levelSize-- > 0){
                   //Pair<Integer, Integer> node = traverseQ.poll();
                   //isVisited.add(node);

                   for(int[] dir : dirs){
                       int nodeX = gate.getKey();
                       int nodeY = gate.getValue();
                       int newX = nodeX + dir[0];
                       int newY = nodeY + dir[1];
                       Pair<Integer, Integer> newNode = new Pair(newX, newY);
                       if(newX >= 0 && newX < rows && 
                          newY >= 0 && newY < cols && 
                          rooms[newX][newY] != -1 && 
                          rooms[newX][newY] != 0 &&
                          //Below check enforces the first visit only
                          rooms[newX][newY] == Integer.MAX_VALUE){ 
                          //!isVisited.contains(newNode)){
                           //rooms[newX][newY] = Math.min(rooms[newX][newY], level);
                           rooms[newX][newY] = rooms[nodeX][nodeY] + 1;
                           //traverseQ.offer(newNode);
                           gatesQ.offer(newNode);
                       }
                   }                                      
               }
               //++level;             
            //}
        //}
        
    }
}