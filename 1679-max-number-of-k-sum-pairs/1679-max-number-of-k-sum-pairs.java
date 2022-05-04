class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for(int num : nums){
            int diff = k - num;
            if(diff == num && freqMap.get(diff) > 1){                    
                result++;
                freqMap.put(diff, freqMap.get(diff) - 2);
            }else if(diff != num && freqMap.containsKey(diff) && 
                     freqMap.get(diff) > 0 && freqMap.get(num) > 0){
                result++;
                freqMap.put(diff, freqMap.get(diff) - 1);
                freqMap.put(num, freqMap.get(num) - 1);
            }
            // System.out.println(result + " " + diff + " " + num + " " + 
            //                    freqMap.get(diff) + " " + freqMap.get(num));
        }
        return result;
    }
}