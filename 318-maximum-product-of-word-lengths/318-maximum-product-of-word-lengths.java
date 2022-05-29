class Solution {
    private int bitNumber(char c){
        return (int)c - (int)'a';
    }
    public int maxProduct(String[] words) {
        Map<Integer, Integer> bitmaskMap = new HashMap<Integer, Integer>();
        
        
        for(String word : words){
            int bitmask = 0;
            for(char c : word.toCharArray()){
                bitmask |= (1 << bitNumber(c));
            }
            bitmaskMap.put(bitmask, Math.max(bitmaskMap.getOrDefault(bitmask, 0), word.length()));
        }
        
        int maxProd = 0;
        for(int bitmaskA : bitmaskMap.keySet()){
            for(int bitmaskB : bitmaskMap.keySet()){
                if((bitmaskA & bitmaskB) == 0){
                    maxProd = Math.max(maxProd, bitmaskMap.get(bitmaskA) * bitmaskMap.get(bitmaskB));
                }
            }
        }
        return maxProd;
    }
}