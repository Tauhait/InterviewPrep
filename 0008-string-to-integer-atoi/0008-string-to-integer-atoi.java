class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        int len = sb.length();
        if(len == 0)
            return 0;
        if(len == 1)
            return Character.isDigit(s.charAt(0)) ? s.charAt(0) - '0' : 0;

        
        long ans = 0;
        int index = 0;
        int negPos = sb.charAt(index) == '-' ? -1 : 1;
        if(negPos == -1 || sb.charAt(index) == '+'){
            index++;
        }
        if(!Character.isDigit(sb.charAt(index)))
            return 0;
        for(int i = index; i < len; i++){
            if(!Character.isDigit(sb.charAt(i)))
                break;
            ans *= 10;
            ans += (sb.charAt(i) - '0');
            if(negPos*ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(negPos*ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        ans *= negPos;
        return (int) (ans);
    }
}