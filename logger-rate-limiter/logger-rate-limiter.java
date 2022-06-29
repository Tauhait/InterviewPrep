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
        /*
        It's said in the problem description that "It is possible that several messages arrive roughly at the same time.". I think that the solution should be thread safe. In reality, it happens that multiple thread tries to log the same message at the same time. If that happens, using ConcurrentHashMap is not good enough. You still need to lock the map before read it, and release it after write. Here I'm using double checked lock to avoid unnecessary locking.
The outside read helps avoid unnecessary thread lock.
ConcurrentHashMap only guarantees that when you put, all get method from all threads will read the same value from main memory.

However, situation here is slightly different. You Get first, make condition check, then put. ConcurrentHashMap can not guarantee these three steps executed in sequence without other threads' interruption. in other word, without synchronized, there will be a chance some thread make condition check before you Put be executed. That will end up two thread log same msg which is not acceptable.

        */
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