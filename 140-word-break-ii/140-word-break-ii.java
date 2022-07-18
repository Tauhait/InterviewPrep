class Solution {
    public Map<String, List<String>> memo = new HashMap<String, List<String>>(); 

    public List<String> wordBreak(String s, List<String> wordDict) {
        return topDown(s, new HashSet<>(wordDict), memo);
    }

    private List<String> topDown(String s, Set<String> wordDict, Map<String, List<String>> memo) {

        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<String>();
        if(wordDict.contains(s)) {
            result.add(s);
        }

        for(int endIndex = 1; endIndex <= s.length(); endIndex++) {
            if(wordDict.contains(s.substring(0, endIndex))) {
                for (String ss : topDown(s.substring(endIndex), wordDict, memo)) {
                    result.add(s.substring(0, endIndex) + " " + ss);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}