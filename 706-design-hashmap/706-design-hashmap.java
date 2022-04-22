class MyHashMap {
    private Bucket hMap[];
    private final int buckets = 769;
    public MyHashMap() {        
        hMap = new Bucket[buckets];
        for(int i = 0; i < buckets; i++){
            hMap[i] = new Bucket();
        }
    }
    protected int _hash(int key){
        return key % buckets;
    }
    public void put(int key, int value) {
        hMap[_hash(key)].set(key, value);
    }
    
    public int get(int key) {
        return hMap[_hash(key)].getVal(key);
    }
    
    public void remove(int key) {
        hMap[_hash(key)].remove(key);
    }
}
class Pair {
    private int key;
    private int val;
    public Pair(int key, int val){
        setKey(key);
        setVal(val);
    }
    public void setKey(int key){
        this.key = key;
    }
    public void setVal(int val){
        this.val = val;
    }
    public int getKey(){ 
        return this.key;
    }
    public int getVal(){
        return this.val;
    }
    @Override
    public boolean equals(Object obj){
        Pair other = (Pair)obj;
        return this.key == other.key;
    }
}
class Bucket {    
    private List<Pair> myList;
    public Bucket(){
        myList = new ArrayList<Pair>();
    }
    public int getVal(int key){
        for(int i = 0; i < myList.size(); i++){
            Pair p = myList.get(i);
            if(p.getKey() == key){
                return p.getVal();
            }
        }
        return -1;
    }
    public void set(int key, int val){
        Pair p = new Pair(key, val);
        int loc = findLoc(key);
        if(loc != -1){
            this.myList.get(loc).setVal(val);
        }else {
            this.myList.add(p);
        }        
    }
    public void remove(int key){
        for(int i = 0; i < myList.size(); i++){
            Pair p = myList.get(i);
            if(p.getKey() == key){
                myList.remove(i);
                break;
            }
        }
    }
    private int findLoc(int key){
        for(int i = 0; i < myList.size(); i++){
            Pair p = myList.get(i);
            if(p.getKey() == key){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */