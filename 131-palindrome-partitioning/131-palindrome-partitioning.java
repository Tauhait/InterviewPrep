class Solution {
    private List<List<String>> ans;
    
    private boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
    private void backtrack(String s, int index, List<String> substr){
        if(index == s.length()) {
            ans.add(new ArrayList<String>(substr));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                substr.add(s.substring(index, i+1));
                backtrack(s, i+1, substr);
                substr.remove(substr.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>());
        return ans;
    }
    //time complexity =  O(N * 2^N)
    //space complexity = O(N)
}