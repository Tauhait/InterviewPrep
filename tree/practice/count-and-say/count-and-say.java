class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String digitSay = countAndSay(n - 1);

        StringBuilder newDigitSay = new StringBuilder();
        int freq = 0;
        for(int i = 0; i < digitSay.length(); i++){
            freq++;
            if( i == digitSay.length() - 1 || 
                digitSay.charAt(i) != digitSay.charAt(i + 1)){
                
                newDigitSay.append(String.valueOf(freq));
                newDigitSay.append(digitSay.charAt(i));                
                freq = 0;
            }
        }
        return newDigitSay.toString();
    }
}