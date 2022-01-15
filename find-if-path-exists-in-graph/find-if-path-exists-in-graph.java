class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.isConnected(start, end);
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;
    
    public UnionFind(int n){
        group = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            group[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int vertex){
        if(group[vertex] != vertex){
            group[vertex] = find(group[vertex]);
        }
        return group[vertex];
    }
    
    public void union(int vertexA, int vertexB){
        int groupVertexA = find(vertexA);
        int groupVertexB = find(vertexB);
        if(groupVertexA != groupVertexB){
            if(rank[groupVertexA] > rank[groupVertexB]){
                group[groupVertexB] = groupVertexA;
            }else if(rank[groupVertexA] < rank[groupVertexB]){
                group[groupVertexA] = groupVertexB;
            }else {
                group[groupVertexA] = groupVertexB;
                rank[groupVertexA]++;
            }
        }
    }
    
    public boolean isConnected(int vertexA, int vertexB){
        return find(vertexA) == find(vertexB);
    }
}