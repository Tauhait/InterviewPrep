class MyHashSet {
    //find a prime less than 1/100 of MAX RANGE (10^4 is 1/100th of 10^6)
    // private int MOD = 9973;
    private int MOD = 769;
    private Bucket[] buckets;
    
    public MyHashSet() {
        buckets = new Bucket[MOD];
        for(int i = 0; i < MOD; i++) buckets[i] = new Bucket();
    }
    
    private int getHash(int key){
        return key % MOD;
    }
    
    
    public void add(int key) {
        buckets[getHash(key)].insert(key);
    }
    
    public void remove(int key) {        
        buckets[getHash(key)].delete(key);
    }
    
    public boolean contains(int key) {
        return buckets[getHash(key)].exists(key);
    }
}
class Bucket {
    private TreeMap<Integer, Integer> tMap;
    private int index;
    
    public Bucket(){
        tMap = new TreeMap<Integer, Integer>();
        index = -1;
    }
    
    public void insert(int val){
        tMap.put(val, ++index);
    }
    
    public boolean exists(int val){
        return tMap.containsKey(val);
    }
    
    public void delete(int val){
        if(exists(val)) tMap.remove(val);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */