class Solution {
    private void breaks(String s, Set<String> dict, List<String> ans, String solution){
        if(s.length() == 0) { 
            ans.add(new String(solution.trim()));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0, i + 1);
            if(!dict.contains(left)) continue;
            else {
                breaks(s.substring(i + 1), dict, ans, solution + left + " ");
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for(String word : wordDict){
            dict.add(word);
        }
        breaks(s, dict, ans, "");
        return ans;
    }
}