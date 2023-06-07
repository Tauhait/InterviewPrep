public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> xorMap = new HashMap<>();
        xorMap.put(0,1);
        int xorB = 0;
        int xored = 0;
        for(int a : A){
            xored ^= a;
            int diffB = xored ^ B;
            if(xorMap.containsKey(diffB)) xorB += xorMap.get(diffB);
            xorMap.put(xored, xorMap.getOrDefault(xored,0)+1);            
        }
        return xorB;
    }
}
