class Logger {
    private final HashMap<String, Integer> msgMap;
    private final Object lock;
	
    /** Initialize your data structure here. */
    public Logger() {
    	msgMap = new HashMap<String, Integer>();
    	lock = new Object();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer ts = msgMap.get(message);
        if (ts == null || timestamp - ts >= 10) {
        	synchronized (lock) {
        		Integer ts2 = msgMap.get(message);
        		if (ts == null || timestamp - ts2 >= 10) {
		            msgMap.put(message, timestamp);
        			return true;
        		}
        	}
         } 

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */