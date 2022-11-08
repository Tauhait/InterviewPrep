class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stk = new Stack<>();        
        int pos = 0;
        while(pos < s.length()){
            int thisChar = s.charAt(pos++);
            if(!stk.isEmpty() && Math.abs(stk.peek()-thisChar) == 32)
                stk.pop();
            else
                stk.push((char)thisChar);
        }
        while(!stk.isEmpty())
            ans.insert(0, stk.pop());
        return ans.toString();
    }
}