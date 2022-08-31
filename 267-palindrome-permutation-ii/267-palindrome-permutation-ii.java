class Solution {
    private Set<String> palindromePermutations;
    
    private boolean canPermutePalindrome(String s, int[] map){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
            if(map[s.charAt(i)]%2 == 0) count--;
            else count++;
        }
        return count <= 1;
    }
    private void permute(char[] sArr, int start, char mid){
        if(start == sArr.length){
            // if(isPalindrome(sArr)) palindromePermutations.add(new String(sArr));
            palindromePermutations.add( new String(sArr)                + 
                                        (mid == 0 ? "" : mid)           +
                                        new StringBuffer(
                                            new String(sArr)).reverse());
        } else {
            for(int i = start; i < sArr.length; i++){
                if(i == start || sArr[i] != sArr[start]){
                    swap(sArr, i, start);
                    permute(sArr, start+1, mid);
                    swap(sArr, i, start);
                }
            }
        }
    }
    private void swap(char[] sArr, int i, int j){
        char tmp = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = tmp;
    }
    private boolean isPalindrome(char[] sArr){
        int len = sArr.length;
        for(int i = 0; i < len; i++) 
            if(sArr[i] != sArr[len-i-1]) 
                return false;
        return true;
    }
    public List<String> generatePalindromes(String s) {
        int[] map = new int[128];
        char[] sHalf = new char[s.length()/2];
        if(!canPermutePalindrome(s, map)) return new ArrayList<String>();
        char mid = 0;
        int index = 0;
        for(int i = 0; i < 128; i++){
            if(map[i]%2 == 1)
                mid = (char)i;
            for(int j = 0; j < map[i]/2; j++)
                sHalf[index++] = (char)i;
        }
        palindromePermutations = new HashSet<>();
        permute(sHalf, 0, mid);
        return new ArrayList<String>(palindromePermutations);
    }
}