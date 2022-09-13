class Solution {
    private final int zero = 0;
    private final int oneNineTwo  = 192;
    private final int twoTwoFour  = 224;
    private final int twoFourZero = 240;
    private final int oneTwoEight = 128;
    private final int mask1Byte  = zero;
    private final int mask2Byte  = oneNineTwo;
    private final int mask3Byte  = twoTwoFour;
    private final int mask4Byte  = twoFourZero;
    private final int maskCommon = oneTwoEight;
    
    private boolean isValid(int start, int end, int slen, int[] data){
        if(end >= slen) return false;
        for(int i = start; i <= end && i < slen; i++){
            String temp = Integer.toString(data[i],2);
            if((data[i] & maskCommon) != oneTwoEight || temp.charAt(1) != '0') return false;
        }
        return true;
    }
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int index = 0;
        
        while(index < len){
            int d = data[index];
            String dstr = Integer.toString(d,2);
            if(dstr.length() < 8 || dstr.charAt(0) == '0'){
                index++;
            }else if((d & mask4Byte) == twoFourZero && dstr.charAt(4) == '0'){
                if(!isValid(index+1, index+3, len, data)) return false;
                index += 4;
            }else if((d & mask3Byte) == twoTwoFour && dstr.charAt(3) == '0'){
                if(!isValid(index+1, index+2, len, data)) return false;
                index += 3;
            }else if((d & mask2Byte) == oneNineTwo && dstr.charAt(2) == '0'){
                if(!isValid(index+1, index+1, len, data)) return false;
                index += 2;
            }else {
                return false;
            }
        }
        return true;
    }
}