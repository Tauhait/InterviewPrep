class Solution {
    private void buildStack(Stack<Character> stack, String str){
        for(char c : str.toCharArray()){
            if(c == '#' && !stack.isEmpty()) stack.pop();
            else if(c != '#') stack.push(c);
        }
    }
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        buildStack(stackS, s);
        buildStack(stackT, t);
        while(!stackS.isEmpty() && !stackT.isEmpty()){
            if(stackS.pop() != stackT.pop()) return false;
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
}