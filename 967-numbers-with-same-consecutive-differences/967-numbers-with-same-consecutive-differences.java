class Solution {
    private List<String> numbers;
    
    private void backtrack(StringBuilder number, int n, int k){
        if(number.length() == n) {
            numbers.add(number.toString());
            return;
        }
        for(int i = 0; i <= 9; i++){
            int nlen = number.length();
            if(i == 0 && nlen == 0) continue;
            if(nlen == 0) number.append(i);
            else {
                int absDiff = Math.abs(i - (Integer.valueOf(number.charAt(nlen-1))-48));
                if(absDiff != k) continue;
                number.append(i); 
            }
            backtrack(number, n, k);
            number.deleteCharAt(nlen);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        numbers = new ArrayList<String>();
        backtrack(new StringBuilder(), n, k);
        int[] ans = new int[numbers.size()];
        
        for(int i = 0; i < numbers.size(); i++)
            ans[i] = Integer.valueOf(numbers.get(i));
        return ans;
    }
}