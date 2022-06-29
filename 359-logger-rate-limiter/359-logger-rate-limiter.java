class Logger {
    private HashMap<String,Integer> lastLogged;
    private final int THRESHOLD = 10;
    
    public Logger() {
        lastLogged = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        Set<String> keys = new HashSet<String>(lastLogged.keySet());
        for(String key : keys) {
            if(timestamp - lastLogged.get(key) >= THRESHOLD) {
                lastLogged.remove(key);
            }
        }
        if((timestamp-lastLogged.getOrDefault(message, timestamp-(THRESHOLD+1))) >= THRESHOLD){
            lastLogged.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */