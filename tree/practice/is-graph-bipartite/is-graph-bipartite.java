class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        
        UnionFind uf = new UnionFind(nodes);
        
        for(int i = 0; i < graph.length; i++){
            int nodeParent = uf.find(i);
            for(int edge : graph[i]){
                if(nodeParent == uf.find(edge)){
                    return false;
                }
                uf.union(graph[i][0], edge);
            }
        }
        return true;
    }
}
class UnionFind {
    private int[] group;
    private int[] rank;
    
    public int[] getGroup(){
        return group;
    }
    public int[] getRank(){
        return rank;
    }
    public UnionFind(int size){
        group = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            group[i] = i;
            rank[i] = 0;
        }
    }
    
    public void union(int x, int y){
        int groupX = find(x);
        int groupY = find(y);
        if(groupX != groupY){
            if(rank[groupX] > rank[groupY]){
                group[groupY] = groupX;
            }else if(rank[groupX] < rank[groupY]){
                group[groupX] = groupY;
            }else {
                group[groupX] = groupY;
                rank[groupX]++;
            }
        }
    }
    
    public int find(int node){
        if(node != group[node]) group[node] = find(group[node]);
        return group[node];
    }
}