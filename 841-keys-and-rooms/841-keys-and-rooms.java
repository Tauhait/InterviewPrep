class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(0);
        int n = rooms.size();
        Set<Integer> keySet = new HashSet();
        keySet.add(0);
        while(!queue.isEmpty()){
            int enterRoom = queue.poll();
            List<Integer> keys = rooms.get(enterRoom);
            for(Integer key : keys){
                if(!keySet.contains(key)){
                    keySet.add(key);
                    queue.offer(key);
                }                
            }
        }
        return keySet.size() == n;
    }
}