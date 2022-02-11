class Solution {
    public String decodeString(String s) {
        StringBuilder finalStr = new StringBuilder();
        Stack<String> repeatStk = new Stack();
        repeatStk.push("#");
        Stack<String> substrStk = new Stack();
        char[] inputSeq = s.toCharArray();
        for(char c : inputSeq){
            if(Character.isDigit(c)){
                repeatStk.push(Character.toString(c));                
            }else if(c == '['){
                repeatStk.push("#");
                substrStk.push(Character.toString(c));
            }else if(Character.isLetter(c)){
                substrStk.push(Character.toString(c));
            }else {
                StringBuilder subseq = new StringBuilder();
                while(!substrStk.isEmpty() && !substrStk.peek().equals("[")){
                    subseq.insert(0, substrStk.pop());
                }
                if(substrStk.peek().equals("[")){
                    substrStk.pop();//pop out '['
                }
                
                int repeat = 0;
                
                repeatStk.pop();//pop out top # boundary
                StringBuilder repeater = new StringBuilder();
                while(!repeatStk.isEmpty() && !repeatStk.peek().equals("#")){
                    repeater.insert(0, repeatStk.pop());
                }
                if(!repeater.toString().equals("")){
                    repeat = Integer.parseInt(repeater.toString());
                    repeat--; 
                }
                
                String singleSubseq = subseq.toString();
                while(repeat-- > 0){
                    subseq.append(singleSubseq);
                }
                substrStk.push(subseq.toString());
                
            }
        }
        while(!substrStk.isEmpty()){
            finalStr.insert(0, substrStk.pop());
        }
        return finalStr.toString();
    }
}