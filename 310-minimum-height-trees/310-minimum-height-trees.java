class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<Integer>();
            for (int i = 0; i < n; i++){
                centroids.add(i);
            }
            return centroids;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList<Integer>());            
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (adjList.get(i).size() == 1){
                leaves.add(i);
            }
        }
        // Trim the leaves until reaching the centroids
        int remNodes = n;
        while(remNodes > 2){
            remNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            
            // remove the current leaves along with the edges
            for(Integer leaf : leaves){
                // the only neighbor left for the leaf node
                int neighbor = adjList.get(leaf).get(0);
                // remove the edge along with the leaf node
                adjList.get(neighbor).remove(leaf);
                if(adjList.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        // The remaining nodes are the centroids of the graph, last round leaves added are them.
        return leaves;
    }
}