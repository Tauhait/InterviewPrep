class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        int source = 0;
        List<Integer> path = new ArrayList<Integer>();
        path.add(source);
        dfs(graph, path, pathList, source);//Traverse all paths originating from source        
        return pathList;
    }
    private void dfs(int[][] graph, List<Integer> path, List<List<Integer>> paths, int node){        
        if(node == graph.length - 1) {//If last node is reached then copy the entire path and add to the path list
            paths.add(new ArrayList<Integer>(path));
        }
        else {
            for(int nextNode : graph[node]){//Iterate adjacency list of node
                path.add(nextNode);//Add the next node in path
                dfs(graph, path, paths, nextNode);// Do DFS on the next node
                path.remove(path.size() - 1);//Backtrack
            }
        }
    }
}