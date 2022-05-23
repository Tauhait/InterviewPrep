class Solution {
    public int countSubstrings(String str) {
        if(str == null || str.length() < 1) return 0;
        int globalCount = 0;
        for(int i = 0;i < str.length(); i++){
            globalCount += countPalindromes(str, i, i) + countPalindromes(str, i, i + 1); 
        }
        return globalCount;
    }    
    private int countPalindromes(String str, int start, int end){
        int localCount = 0;
        while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
            localCount++;
        }
        return localCount;
    }
}