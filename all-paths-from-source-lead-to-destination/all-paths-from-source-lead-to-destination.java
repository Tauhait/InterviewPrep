class Solution {
    enum State { PROCESSING, PROCESSED }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new List[n];
        for(int vertex = 0; vertex < n; vertex++){
            adjList[vertex] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
        }
        
        return leadsToDestHelper(adjList, new State[n], source, destination);        
    }
    
    private boolean leadsToDestHelper(List<Integer>[] graph, State states[], int node, int dest){
        if(states[node] != null){
            //if the state of node being explored is PROCESSING then it means CYCLE!
            return states[node] == State.PROCESSED;
        }
        if(graph[node].isEmpty()){
            //Has to destination node
            return node == dest;
        }
        
        //set node to PROCESSING
        states[node] = State.PROCESSING;
        //Explore the neighbor in DFS way
        for(int next : graph[node]){
            if(!leadsToDestHelper(graph, states, next, dest)){
                return false;
            }
        }
        //set node to PROCESSED
        states[node] = State.PROCESSED;
        return true;
    }
}