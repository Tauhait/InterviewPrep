class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String digitSay = countAndSay(n-1);
        StringBuilder newDigitSay = new StringBuilder();
        int freq = 0;
        for(int i = 0; i < digitSay.length(); i += freq){
            freq = 0;
            for(int j = i; j < digitSay.length() && digitSay.charAt(j) == digitSay.charAt(i); j++){
                freq++;
            }
            newDigitSay.append(String.valueOf(freq));
            newDigitSay.append(digitSay.charAt(i));
        }
        return newDigitSay.toString();
    }
}