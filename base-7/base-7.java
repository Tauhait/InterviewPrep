class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        boolean isNeg = false;
        if(num < 0){
            isNeg = true;
            num *= -1;
        }
            
        StringBuilder ans = new StringBuilder();
        while(num > 0){
            ans.insert(0, num % 7);
            num /= 7;
        }
        if(isNeg)
            ans.insert(0,"-");
        return ans.toString();
    }
}