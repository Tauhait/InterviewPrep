class Solution {
    public List<Integer> grayCode(int n) {
        int loop = (1<<n);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < loop; i++){
            int numCopy = i;
            int lastbit = (numCopy&1);
            int gray = 0;
            int shift = 0;
            numCopy >>>= 1;
            while(numCopy != 0){
                int bit = (numCopy&1);
                gray |= ((bit ^ lastbit) << shift);
                numCopy >>>= 1;
                shift++;
                lastbit = bit;
            }
            gray |= (lastbit << shift);
            ans.add(gray);
        }
        return ans;
    }
}