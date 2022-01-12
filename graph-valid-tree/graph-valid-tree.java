class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Max n - 1 edges can be present in a tree
        if(edges.length != n - 1){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            //check if merge or union is making a cycle
            if(!uf.union(edge[0], edge[1])){                
                return false;
            }
        }
        return true;
        
    }
    class UnionFind {
        private int[] root;
        private int[] rank;
        public UnionFind(int nodes){
            root = new int[nodes];
            rank = new int[nodes];
            for(int node = 0 ; node < nodes; node++){
                rank[node] = 1;
                root[node] = node;
            }
        }
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return root[x] = find(root[x]);
        }
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                //Cycle
                return false;
            }else {
                if(rank[rootX] > rank[rootY]){
                    root[rootX] = rootY;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootY] = rootX;
                }else {
                    root[rootX] = rootY;
                    rank[rootX] += 1;
                }
            }
            return true;
        }
    }
}