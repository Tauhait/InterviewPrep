class Solution {
    HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    LinkedList<String> result = null;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            
            if(flightMap.containsKey(origin)){
                LinkedList<String> destList = flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                flightMap.put(origin, destList);
            }
        }
        
        for(Map.Entry<String, LinkedList<String>> entry : flightMap.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        result = new LinkedList<String>();
        DFS("JFK");
        return result;
    }
    
    public void DFS(String origin){//Post-order DFS
        if(flightMap.containsKey(origin)){
            LinkedList<String> destList = flightMap.get(origin);
            while(!destList.isEmpty()){
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        result.offerFirst(origin);
    }
}