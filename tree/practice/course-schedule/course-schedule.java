class Solution {
    private boolean dfs(int node, Map<Integer, List<Integer>> adj, Map<Integer, Integer> visited){
        if(visited.containsKey(node)) return visited.get(node) == 2;
        visited.put(node, 1);
        for(int neighbor : adj.get(node)){
            if(!dfs(neighbor, adj, visited)) return false;
            visited.put(neighbor, 2);
        }
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<Integer>());
        }
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            List<Integer> prerequisiteList = adj.get(course);
            prerequisiteList.add(prereq);            
        }
        Map<Integer, Integer> complete = new HashMap<>();
        for(int course : adj.keySet()){
            if(!complete.containsKey(course) && dfs(course, adj, complete)){
                complete.put(course, 2);
            }
        }
        for(int course : complete.keySet()){
            if(complete.get(course) != 2) return false;
        }
        return true;
    }
}