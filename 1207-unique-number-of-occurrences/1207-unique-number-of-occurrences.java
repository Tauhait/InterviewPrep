class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] uniqCount = new int[2005];
        for(int a : arr){
            uniqCount[a+1000]++;
        }
        Set<Integer> uniq = new HashSet<>();
        for(int u : uniqCount){            
            if(u == 0)
                continue;
            if(uniq.contains(u)){
                return false;
            }
            uniq.add(u);
        }
        return true;
    }
}