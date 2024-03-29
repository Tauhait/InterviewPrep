class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        1. Make Graph using hashmap and list 
        2. Make a Dist Map
        3. Build a PQ to select the next node to hop on
        4. Calc dist using dist map
        */
        HashMap<Integer, List<int[]>> graph = new HashMap();
        for(int[] edge : times){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((dist1, dist2) -> Integer.compare(dist1[0], dist2[0]));
        heap.offer(new int[]{0, k});//{distance, node number}
        
        //to check if a node is already visited,
        //also stores shortest distance info from node k to every other node
        Map<Integer, Integer> dist = new HashMap(); 
        int total_time = 0;
        
        while(!heap.isEmpty()){
            int[] info = heap.poll();
            int dist_fromK = info[0];
            int thisNode = info[1];
            if(dist.containsKey(thisNode)){//if already visited
                //since we extract from min heap it means we already have visited thisNode 
                //using the shortest path
                continue;
            }else {
                dist.put(thisNode, dist_fromK);
            }
            total_time = dist_fromK;
            n--;
            //Check for neighbors
            if(graph.containsKey(thisNode)){
                for(int[] edge : graph.get(thisNode)){
                    int nextNode = edge[0];
                    int distFromThisNode = edge[1];
                    if(!dist.containsKey(nextNode)){//if not yet visited
                        heap.offer(new int[]{dist_fromK + distFromThisNode, nextNode});
                    }
                }
            }
        }
        return n == 0 ? total_time : -1;
    }
}