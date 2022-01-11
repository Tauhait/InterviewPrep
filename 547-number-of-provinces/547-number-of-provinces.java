class Solution {
    private int[] root;
    private int[] rank;
    public void initGraph(int nodes){
        root = new int[nodes];
        rank = new int[nodes];
        for(int node = 0; node < nodes; node++){
            root[node] = node;
            rank[node] = 1;
        }
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else {
                root[rootX] = rootY;
                rank[rootX]++;
            }
        }
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
    public int find(int x){
        if(x == root[x]){
            return root[x];
        }
        root[x] = find(root[x]);
        return root[x];
    }
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0){
            return 0;
        }
        int nodes = isConnected.length;
        initGraph(nodes);
        for(int node = 0; node < nodes; node++){
            for(int edge = node; edge < nodes; edge++){
                if(isConnected[node][edge] == 1){
                    union(node, edge);
                }
            }
        }
        
        Set<Integer> provinces = new HashSet<Integer>();
        for(int node = 0; node < nodes; node++){
            provinces.add(find(node));
        }
        return provinces.size();
    }
}