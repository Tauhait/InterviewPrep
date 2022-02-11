class Solution {
    public String decodeString(String s) {
        StringBuilder finalStr = new StringBuilder();
        Stack<String> repeatStk = new Stack();
        repeatStk.push("#");
        Stack<String> substrStk = new Stack();
        //StringBuilder subseq = new StringBuilder();
        char[] inputSeq = s.toCharArray();
        //boolean numericStatus = false;
        for(char c : inputSeq){
            if(Character.isDigit(c)){
                repeatStk.push(Character.toString(c));                
            }else if(c == '['){
                repeatStk.push("#");
                substrStk.push(Character.toString(c));
            }else if(Character.isLetter(c)){
                substrStk.push(Character.toString(c));
            }else {
                //numericStatus = true;
                StringBuilder subseq = new StringBuilder();
                while(!substrStk.isEmpty() && !substrStk.peek().equals("[")){
                    subseq.insert(0, substrStk.pop());
                }
                //System.out.println(subseq.toString());
                if(substrStk.peek().equals("[")){
                    substrStk.pop();//pop out '['
                }
                
                int repeat = 0;
                
                repeatStk.pop();//pop out top # boundary
                StringBuilder repeater = new StringBuilder();
                //System.out.println(repeatStk.size());
                //System.out.println(repeatStk.peek());
                while(!repeatStk.isEmpty() && !repeatStk.peek().equals("#")){
                    repeater.insert(0, repeatStk.pop());
                }
                if(!repeater.toString().equals("")){
                    repeat = Integer.parseInt(repeater.toString());
                    repeat--; 
                }
                
                String singleSubseq = subseq.toString();
                //System.out.println(singleSubseq);
                while(repeat-- > 0){
                    //System.out.println(subseq);
                    subseq.append(singleSubseq);
                }
                //System.out.println(subseq);
                //System.out.println("----");
                substrStk.push(subseq.toString());
                //System.out.println(substrStk.peek());
                //System.out.println("----");
                
            }
        }
        while(!substrStk.isEmpty()){
            finalStr.insert(0, substrStk.pop());
        }
        return finalStr.toString();
    }
}