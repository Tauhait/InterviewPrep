class Solution {
    private int mask1Byte  = 0;
    private int mask2Byte  = 192;
    private int mask3Byte  = 224;
    private int mask4Byte  = 240;
    private int maskCommon = 128;
    
    public boolean validUtf8(int[] data) {
        int len = data.length;
        int index = 0;
        
        while(index < len){
            int d = data[index];
            String dstr = Integer.toString(d,2);
            if(dstr.length() < 8 || dstr.charAt(0) == '0'){
                index++;
            }else if((d & mask4Byte) == 240 && dstr.charAt(4) == '0'){
                if(index+3 >= len) return false;
                for(int i = index + 1; i <= index + 3 && i < len; i++){
                    String temp = Integer.toString(data[i],2);
                    if((data[i] & maskCommon) != 128 || temp.charAt(1) != '0') return false;
                }
                index += 4;
            }else if((d & mask3Byte) == 224 && dstr.charAt(3) == '0'){
                if(index+2 >= len) return false;
                for(int i = index + 1; i <= index + 2 && i < len; i++){
                    String temp = Integer.toString(data[i],2);
                    if((data[i] & maskCommon) != 128 || temp.charAt(1) != '0') return false;
                }
                index += 3;
            }else if((d & mask2Byte) == 192 && dstr.charAt(2) == '0'){
                if(index+1 >= len) return false;
                for(int i = index + 1; i <= index + 1 && i < len; i++){
                    String temp = Integer.toString(data[i],2);
                    if((data[i] & maskCommon) != 128 || temp.charAt(1) != '0') return false;
                }
                index += 2;
            }else {
                return false;
            }
        }
        return true;
    }
}