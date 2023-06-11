class Solution {
    private List<List<String>> ans;
    private boolean isPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    private void generateSubstrings(String s, int start, List<String> substring){
        if(start >= s.length()) {
            ans.add(new ArrayList<String>(substring));
            return;
        }
        for(int end = start; end < s.length(); end++){
            String substr = s.substring(start, end+1);
            if(isPalindrome(substr)){
                substring.add(substr);
                generateSubstrings(s, end+1, substring);
                substring.remove(substring.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        generateSubstrings(s, 0, new ArrayList<String>());
        return ans;
    }
}