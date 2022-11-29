class RandomizedSet {
    private HashMap<Integer, Integer> valToIdx;
    private LinkedList<Integer> idxList;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToIdx = new HashMap<Integer,Integer>();
        idxList = new LinkedList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIdx.containsKey(val)) return false;
        idxList.add(val);
        valToIdx.put(val, idxList.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)) return false;
        int idx = valToIdx.get(val);
        int getLastElem = idxList.get(idxList.size()-1);
        idxList.set(idx, getLastElem);
        valToIdx.put(getLastElem, idx);
        valToIdx.remove(val);
        idxList.remove(idxList.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return idxList.get(rand.nextInt(idxList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */