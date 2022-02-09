class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        if(s.length() % 2 == 1)
            return false;
        char[] closeBraces = {')','}',']'};
        Stack<Character> parenCheck = new Stack<Character>();
        
        for(int i=0; i < s.length(); i++){
            char paren = s.charAt(i);
            
            if((paren == closeBraces[0] || paren == closeBraces[1] || paren == closeBraces[2])){
                if(!parenCheck.empty()){
                    char open = parenCheck.pop();                    
                    if(!((open == '(' && paren == ')') || 
                         (open == '{' && paren == '}') ||
                         (open == '[' && paren == ']') ))
                        return false;
                } else {
                    return false;
                }             
                    
            }else {
                parenCheck.push(paren);               
            }
        }
       
        return parenCheck.empty();
    }
}