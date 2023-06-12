class Solution {
    class ElementFreq implements Comparable<ElementFreq> {
        Integer element;
        Integer freq;
        public ElementFreq(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
        @Override
        public int compareTo(ElementFreq other){
            return this.freq.compareTo(other.freq);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<ElementFreq> pq = new PriorityQueue<>();
        Map<Integer,Integer> mpp = new HashMap<>();

        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
        for(int key : mpp.keySet()){
            ElementFreq ef = new ElementFreq(key, mpp.get(key));
            pq.add(ef);
            if(pq.size() > k){ pq.poll(); }
        }
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--){
            ans[i] = pq.poll().element;
        }
        return ans;        
    }
}