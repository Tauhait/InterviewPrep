class Solution {
    
    public int minDeletions(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<Character, Integer>();//O(26)
        PriorityQueue<Integer> sameCharFreqQ = new PriorityQueue<Integer>();//O(n)
        Set<Integer> uniqueFreqSet = new HashSet<Integer>();//O(26)
        
        //char freq calc step
        for(char c : s.toCharArray()) charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        //find same and uniq freq values
        for(Map.Entry<Character, Integer> entry : charFreqMap.entrySet()){
            int val = entry.getValue();
            if(uniqueFreqSet.contains(val)) sameCharFreqQ.add(val);
            else uniqueFreqSet.add(val);
        }
        int ans = 0;
        while(!sameCharFreqQ.isEmpty()){
            int topFreqStart = sameCharFreqQ.poll();
            int topFreqEnd = topFreqStart - 1;
            while(topFreqEnd > 0 && uniqueFreqSet.contains(topFreqEnd)) topFreqEnd -= 1;
            // System.out.println(topFreqStart + "," + topFreqEnd);            
            ans += topFreqStart - topFreqEnd;
            // System.out.println(ans);
            if(topFreqEnd == 0) continue;
            uniqueFreqSet.add(topFreqEnd);
                       
        }
        return ans;
    }
}