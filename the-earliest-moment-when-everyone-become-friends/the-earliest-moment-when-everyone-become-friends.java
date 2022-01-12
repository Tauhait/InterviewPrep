class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        UnionFind uf = new UnionFind(n);
        for(int[] log : logs){
            //System.out.println(uf.getComponents());            
            uf.union(log[1], log[2]);            
            if(uf.getComponents() == 1){
                return log[0];
            }
        }
        return -1;
    }
    class UnionFind {
        private int[] root;
        private int[] rank;
        private int components;
        public UnionFind(int nodes){
            root = new int[nodes];
            rank = new int[nodes];
            components = nodes;
            for(int node = 0; node < nodes; node++){
                root[node] = node;
                rank[node] = 1;
            }
        }
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
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
    }
}