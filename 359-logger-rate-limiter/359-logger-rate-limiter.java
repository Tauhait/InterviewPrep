class Logger {
    private Map<String, Integer> msgTimeMap;
    private final int deltaTime = 10;
    public Logger() {
        this.msgTimeMap = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(msgTimeMap.containsKey(message)){ 
           if(Math.abs(timestamp - msgTimeMap.get(message)) >= deltaTime){
                msgTimeMap.put(message, timestamp);
                return true;
            }else return false;
        }
        msgTimeMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */