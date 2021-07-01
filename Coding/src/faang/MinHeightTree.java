package faang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Adjacency list
ArrayList<Set<Integer>> neighbors = new ArrayList<>();
for (int i = 0; i < n; i++)
    neighbors.add(new HashSet<Integer>());

for (int[] edge : edges) {
    Integer start = edge[0], end = edge[1];
    neighbors.get(start).add(end);
    neighbors.get(end).add(start);
}

Adjacency list print        
for(int i=0; i<adjList.size(); i++){
    System.out.print(i+"-->");
    for(int j=0; j<adjList.get(i).size(); j++){
        System.out.print(adjList.get(i).get(j)+" ");
    }
    System.out.println();
}
*/
public class MinHeightTree {
	/*
	 * Naive Solution - O(N^2)
	 */
	
	/*
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList<Integer>());            
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        List<Integer> minHtRootLst = new ArrayList<Integer>();
        int[] minHt = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minHt[i] = findHeight(n, i, adjList);
            if(minHt[i] < min){
                min = minHt[i];
            }
        }
        for(int i=0; i<n; i++){
            if(minHt[i] == min){
                minHtRootLst.add(i);
            }
        }
        return minHtRootLst;
        
    }
    private int findHeight(int n, int root, List<List<Integer>> adjList){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(root);
        boolean[] visited = new boolean[n];
        visited[root] = true;
        int ht = 0;
        
        while(q.size() > 0){
            int iter = q.size();
            while(iter-- > 0){
                int node = q.poll();
                List<Integer> neighborList = adjList.get(node);
                for(int i=0; i<neighborList.size(); i++){
                    if(!visited[neighborList.get(i)]){
                        q.offer(neighborList.get(i));
                        visited[neighborList.get(i)] = true;
                    }
                }
            }
            ht++;
        }
        return ht;
    }
    */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<Integer>();
            for (int i = 0; i < n; i++){
                centroids.add(i);
            }
            return centroids;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList<Integer>());            
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        // Initialize the first layer of leaves
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (adjList.get(i).size() == 1){
                leaves.add(i);
            }
        }
        // Trim the leaves until reaching the centroids
        int remNodes = n;
        while(remNodes > 2){
            remNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            
            // remove the current leaves along with the edges
            for(Integer leaf : leaves){
                // the only neighbor left for the leaf node
                int neighbor = adjList.get(leaf).get(0);
                // remove the edge along with the leaf node
                adjList.get(neighbor).remove(leaf);
                if(adjList.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        // The remaining nodes are the centroids of the graph, last round leaves added are them.
        return leaves;
    }

}
