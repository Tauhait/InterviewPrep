class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        int[] map = new int[128];
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            map[c]++;
            if(map[c] % 2 == 0) count--;
            else count++;
        }
        return count <= 1;
    }
}