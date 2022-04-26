class Solution {    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList();
        
        for(int curr = 0; curr < n; curr++){
            for(int next = curr + 1; next < n; next++){
                int cost = Math.abs(points[curr][0] - points[next][0]) + 
                            Math.abs(points[curr][1] - points[next][1]);
                int[] edge = {cost, curr, next};
                allEdges.add(edge);
            }
        }
        
        Collections.sort(allEdges, (a, b) -> a[0] - b[0]);
        
        UnionFind uf = new UnionFind(n);
        int mstCost = 0;
        int edgesUsed = 0;
        
        for(int i = 0; i < allEdges.size() && edgesUsed < n - 1; i++){
            int cost = allEdges.get(i)[0];
            int node1 = allEdges.get(i)[1];
            int node2 = allEdges.get(i)[2];
            
            if(uf.union(node1, node2)){
                mstCost += cost;
                edgesUsed++;
            }
        }
        return mstCost;
    }
}
class UnionFind {
    public int[] group;
    public int[] rank;
    
    public UnionFind(int size){
        group = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            group[i] = i;
        }
    }
    
    public int find(int node){
        if(group[node] != node){
            group[node] = find(group[node]);
        }
        return group[node];
    }
    
    public boolean union(int node1, int node2){
        int group1 = find(node1);
        int group2 = find(node2);
        
        if(group1 == group2){
            return false;
        }
        if(rank[group1] > rank[group2]){
            group[group2] = group1;
        }else if(rank[group1] < rank[group2]){
            group[group1] = group2;
        }else {
            group[group1] = group2;
            rank[group2]++;
        }
        return true;
    }
    
}