class Solution {
    private int level;
    private Set<String> deadendSet;
    private Queue<String> configQueue;
    private Map<String, Boolean> stateStatusMap;
    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
    public void initDeadendSet(String[] deadends){
        deadendSet = new HashSet();
        for(String deadend : deadends){
            deadendSet.add(deadend);
            stateStatusMap.put(deadend, false);
        }
    }
    public Set<String> getDeadends(){
        return deadendSet;
    }
    public int openLock(String[] deadends, String target) {
        setLevel(0);
        stateStatusMap = new HashMap();
        initDeadendSet(deadends);
        
        configQueue = new LinkedList();
        
        String start = "0000";
        if(start.equals(target)){
            return 0;
        }
        if(deadendSet.contains(start)){
            return -1;
        }
        stateStatusMap.put(start, true);
        configQueue.add(start);
        if(bfs(target)){
            return getLevel();
        }
        return -1;
    }
    public boolean bfs(String target){
        while(!configQueue.isEmpty()){
            int size = configQueue.size();
            this.level += 1;
            while(size-- > 0){
                String state = configQueue.poll();
                char[] stateArr = state.toCharArray();
                
                if(stateStatusMap.get(state) && 
                   (findWheelSlots(target, stateArr, 1) || findWheelSlots(target, stateArr, -1))){
                    return true;
                }
                stateStatusMap.put(state, false);               
            }
            //System.out.println(configQueue.size());
        }
        return false;
    }
    public boolean findWheelSlots(String target, char[] stateArr, int move){
        for(int wheel = 0; wheel < 4; wheel++){
            int wheelVal = (int)stateArr[wheel] - 48;
            wheelVal += move;
            if(wheelVal < 0){
                wheelVal = 10 + wheelVal;
            }else {
                wheelVal %= 10;
            }
            
            char orig = stateArr[wheel];
            stateArr[wheel] = (char)(48 + wheelVal);
            
            String newState = String.valueOf(stateArr);
            
            if(!deadendSet.contains(newState) && !stateStatusMap.containsKey(newState)){
                if(newState.equals(target)){
                    return true;
                }
                configQueue.offer(newState);
                stateStatusMap.put(newState, true);
            }
            stateArr[wheel] = orig;
        }
        return false;
    }
}