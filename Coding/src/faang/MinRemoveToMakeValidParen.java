package faang;

import java.util.Stack;

public class MinRemoveToMakeValidParen {
	public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> parenStk = new Stack<Character>();
        int index = 0;
        for(char c : s.toCharArray()) {
            if(c == '(' || c == ')') {
                if(c == ')') {
                    if(parenStk.empty()) sb = sb.deleteCharAt(index--);
                    else if(parenStk.peek() == '(') parenStk.pop();
                }else if(c == '(') parenStk.push(c);                
            }
            ++index;
        }
        index = 0;
        while(!parenStk.empty()){
            parenStk.pop();
            index = sb.lastIndexOf("(");            
            sb = sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}
