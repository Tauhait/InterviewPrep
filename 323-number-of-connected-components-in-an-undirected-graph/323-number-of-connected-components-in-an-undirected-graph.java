class Solution {
    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int edge = 0; edge < edges.length; edge++){
            int x = edges[edge][0];
            int y = edges[edge][1];
            uf.union(x, y);
        }
        return uf.getComponents();
    }
    
    private class UnionFind {
        private int[] root;
        private int[] rank;
        private int components;
        
        public UnionFind(int nodes){
            root = new int[nodes];
            rank = new int[nodes];
            for(int node = 0; node < nodes; node++){
                root[node] = node;
                rank[node] = 1;
            }
            components = nodes;
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootX] = rootY; 
                }else if(rank[rootX] < rank[rootY]){
                    root[rootY] = rootX;
                }else {
                    root[rootX] = rootY;
                    rank[rootX]++;
                }
                --components;
            }
        }
        public int getComponents(){
            return components;
        }
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
        }
        
    }
}