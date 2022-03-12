class Solution {
    private List<String> parenthesisCombList;
    private int maxComb;
    private final String[] parenthesisList = {"(", ")"};
    
    public List<String> generateParenthesis(int n) {
        maxComb = 2 * n;
        parenthesisCombList = new LinkedList();
        backtrack(new StringBuilder());
        return parenthesisCombList;
    }
    private void backtrack(StringBuilder parenCombination){
        //System.out.println(parenCombination.toString());
        if(parenCombination.length() == maxComb){
            parenthesisCombList.add(parenCombination.toString());
            return;
        }
        for(String paren : parenthesisList){
            parenCombination.append(paren);          

            if(isValid(parenCombination.toString(), maxComb)){
                backtrack(parenCombination);
            }
            
            parenCombination.deleteCharAt(parenCombination.length() - 1);
        }
    }
    private boolean isValid(String parenCombination, int len){
        Stack<Character> stk = new Stack();
        for(char c : parenCombination.toCharArray()){
            if(c == '('){
                stk.push(c);
            }else {
                if(stk.empty()){
                    return false;
                }
                stk.pop();
            }
        }
        if(parenCombination.length() == len){
            return stk.isEmpty();
        }
        return true;
    }
}