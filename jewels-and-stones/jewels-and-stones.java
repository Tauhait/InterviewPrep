class Solution {
    private final int CHAR_SET = 52;
    
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[CHAR_SET];
        int jewelStones = 0;
        for(char jewel : jewels.toCharArray()){
            if(Character.isUpperCase(jewel)) isJewel[CHAR_SET/2 + jewel - 'A'] = true;
            else isJewel[jewel - 'a'] = true;
        }
        for(char stone : stones.toCharArray()){
            if(Character.isUpperCase(stone)) {
                if(isJewel[CHAR_SET/2 + stone - 'A']) jewelStones++;
            }else {
                if(isJewel[stone - 'a']) jewelStones++;
            }
        }
        return jewelStones;
    }
}
//Do I need to check for invalid input?