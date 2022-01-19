class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        1. Make Graph
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
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((dist1, dist2) -> dist1[0] - dist2[0]);
        heap.offer(new int[]{0, k});
        
        Map<Integer, Integer> dist = new HashMap();
        
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
        
        if(dist.size() != n){
            return -1;
        }
        int maxDistance = 0;
        for(int distance : dist.values()){
            maxDistance = Math.max(maxDistance, distance);
        }
        return maxDistance;
    }
}