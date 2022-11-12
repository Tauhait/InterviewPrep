class Solution {
    public int myAtoi(String sb) {
        int left = 0, right = sb.length()-1;
        while(left+1 <= right && sb.charAt(left) == ' ')
            left++;
        while(right-1 >= left && sb.charAt(right) == ' ')
            right--;
        // int len = sb.length();
        int len = right-left+1;
        if(len == 0)
            return 0;
        if(len == 1)
            return Character.isDigit(sb.charAt(left)) ? sb.charAt(left) - '0' : 0;

        
        long ans = 0;
        int index = left;
        int negPos = sb.charAt(index) == '-' ? -1 : 1;
        if(negPos == -1 || sb.charAt(index) == '+'){
            index++;
        }
        if(!Character.isDigit(sb.charAt(index)))
            return 0;
        for(int i = index; i <= right; i++){
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