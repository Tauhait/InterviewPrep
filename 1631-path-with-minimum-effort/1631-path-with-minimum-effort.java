class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        if (row == 1 && col == 1) return 0;
        UnionFind unionFind = new UnionFind(heights);
        List<Edge> edgeList = unionFind.edgeList;
        Collections.sort(edgeList, (e1, e2) -> e1.difference - e2.difference);

        for (int i = 0; i < edgeList.size(); i++) {
            int x = edgeList.get(i).x;
            int y = edgeList.get(i).y;
            unionFind.union(x, y);
            if (unionFind.find(0) == unionFind.find(row * col - 1)){
                return edgeList.get(i).difference;
            }
        }
        return -1;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    List<Edge> edgeList;

    public UnionFind(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        parent = new int[row * col];
        edgeList = new ArrayList<>();
        rank = new int[row * col];
        for (int currentRow = 0; currentRow < row; currentRow++) {
            for (int currentCol = 0; currentCol < col; currentCol++) {
                if (currentRow > 0) {
                    edgeList.add(new Edge(currentRow * col + currentCol,
                            (currentRow - 1) * col + currentCol,
                            Math.abs(heights[currentRow][currentCol] - heights[currentRow - 1][currentCol]))
                    );
                }
                if (currentCol > 0) {
                    edgeList.add(new Edge(currentRow * col + currentCol,
                            currentRow * col + currentCol - 1,
                            Math.abs(heights[currentRow][currentCol] - heights[currentRow][currentCol - 1]))
                    );
                }
                parent[currentRow * col + currentCol] = currentRow * col + currentCol;
            }
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            }
            else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            }
            else {
                parent[parentY] = parentX;
                rank[parentX] += 1;
            }
        }
    }
}

class Edge {
    int x;
    int y;
    int difference;

    Edge(int x, int y, int difference) {
        this.x = x;
        this.y = y;
        this.difference = difference;
    }
}