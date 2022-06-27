class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> generatedSet = new HashSet<Integer>();
        
        while(n != 1){
            int copy = n;
            int sum = 0;
            while(copy != 0){
                sum += Math.pow(copy%10, 2);
                copy /= 10;
            }
            n = sum;
            if(generatedSet.contains(n)) return false;
            generatedSet.add(n);
        }
        return true;
    }
}