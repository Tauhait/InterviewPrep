class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> factorsMap = new HashMap();
        int MOD = 1_000_000_007;
        Arrays.sort(arr);
        factorsMap.put(arr[0], 1l);
        
        for(int i = 1; i < arr.length; i++){
            long count = 1;
            for(int key : factorsMap.keySet()){
                if(arr[i]%key == 0 && factorsMap.containsKey(arr[i]/key)){
                    count += factorsMap.get(key) * factorsMap.get(arr[i]/key);
                }
            }
            factorsMap.put(arr[i], count);
        }
        long ans = 0;
        for(long val : factorsMap.values()){
            ans = (ans + val) % MOD;
        }
        return (int)ans;
    }
    
}