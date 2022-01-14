class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> ordEdges = new ArrayList<>(n + 1 + pipes.length);
        
        for(int i = 0; i < wells.length; i++){
            ordEdges.add(new int[]{0, i + 1, wells[i]});
        }
        
        for(int i = 0; i < pipes.length; i++){
            int[] edge = pipes[i];
            ordEdges.add(edge);
        }
        
        Collections.sort(ordEdges, (a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        for(int[] edge : ordEdges){
            int houseA = edge[0];
            int houseB = edge[1];
            int cost = edge[2];
            if(uf.union(houseA, houseB)){
                totalCost += cost;
            }
        }
        return totalCost;
    }
}
class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size){
        group = new int[size + 1];
        rank = new int[size + 1];
        for(int i = 0; i < size + 1; i++){
            group[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(group[x] != x){
            group[x] = find(group[x]);
        }
        return group[x];
    }
    public boolean union(int x, int y){
        int groupA = find(x);
        int groupB = find(y);
        if(groupA == groupB){
            return false;
        }
        
        if(rank[groupA] > rank[groupB]){
            group[groupB] = groupA;
        }else if(rank[groupA] < rank[groupB]){
            group[groupA] = groupB;
        }else {
            group[groupA] = groupB;
            rank[groupB]++;
        }
        return true;
    }
}