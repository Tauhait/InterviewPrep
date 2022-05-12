class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k){
            return nums;
        }
        Map<Integer, Integer> freqMap = new HashMap();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }
        for(int key : freqMap.keySet()){
            buckets[freqMap.get(key)].add(key);
        }
        
        int[] top = new int[k];
        int j = nums.length;
        for(int i = k - 1; i >= 0; ){
            if(buckets[j].size() == 0){
                j--;
                continue;
            }
            List<Integer> bucketList = buckets[j--];
            for(int b : bucketList){
                top[i--] = b;
            }
        }
        return top;
    }
}