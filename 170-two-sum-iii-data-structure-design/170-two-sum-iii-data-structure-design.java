class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) { 
        for(Integer k : map.keySet()){
            int t = value - k;
            if((t == k && map.get(k) > 1) || (t != k && map.containsKey(t))) return true;
        }
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */