class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordMap = new HashMap<String,Integer>();
        
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(
            (A,B)->
            {
                if(wordMap.get(A) == wordMap.get(B)){
                    return A.compareTo(B);
                }else {
                    return wordMap.get(B) - wordMap.get(A);
                }
            }
        );
        for(String word : wordMap.keySet()){            
            pq.add(word);
        }
        
        List<String> result = new ArrayList<String>();
        for(int i = 1; i <= k && !pq.isEmpty(); i++){
            result.add(pq.poll());
        }
        return result;
    }
}