class Solution {    
   public int tryCombinations(int i, List<String> arr, Set<Character> set){
        if(i >= arr.size()) return set.size();

        //if choosed
        String str = arr.get(i);
        int strLen = str.length();
        int choosen = 0;
        if(set.size() + strLen <= 26){
            int idx = 0; 
            while(idx < strLen){
                if(set.add(str.charAt(idx)) == false)
                    break;
                idx++;
            }
            if(idx == strLen){
                choosen = tryCombinations(i+1, arr, set);
            }
            idx--;
            while(idx >= 0){
                set.remove(str.charAt(idx));
                idx--;
            }
        }
        
        //if not choosed
        int nChoosen = tryCombinations(i+1, arr, set);

        return Math.max(choosen, nChoosen);
    }
    public int maxLength(List<String> arr) {
        int ans = 0;
        int n = arr.size();

        Set<Character> set = new HashSet<>();
        ans = tryCombinations(0, arr, set);

        return ans;
    }
}