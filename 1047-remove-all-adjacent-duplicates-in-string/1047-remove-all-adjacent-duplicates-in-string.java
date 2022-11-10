class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(stk.isEmpty())
                stk.push(c);
            else if(stk.peek() == c)
                stk.pop();
            else
                stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.insert(0, stk.pop());
        }
        return sb.toString();
    }
}