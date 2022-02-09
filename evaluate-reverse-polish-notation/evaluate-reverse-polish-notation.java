class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> valueStk = new Stack();
        for(String token : tokens){
            if(token.equals("+") || 
               token.equals("-") || 
               token.equals("/") || 
               token.equals("*")){
                if(valueStk.size() < 2){
                    return Integer.MAX_VALUE;
                }
                int numA = Integer.parseInt(valueStk.pop());//last (second)
                int numB = Integer.parseInt(valueStk.pop());//2nd last (first)
                switch(token){
                    case "+":
                        valueStk.push(String.valueOf(numA + numB));
                        break;
                    case "/":
                        valueStk.push(String.valueOf((int)(numB / numA)));
                        break;
                    case "-":
                        valueStk.push(String.valueOf(numB - numA));
                        break;
                    case "*":
                        valueStk.push(String.valueOf(numB * numA));
                        break;
                }
            }else {
                valueStk.push(token);
            }
        }
        return Integer.parseInt(valueStk.pop());
    }
}