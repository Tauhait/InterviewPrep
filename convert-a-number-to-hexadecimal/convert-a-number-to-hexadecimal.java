/*
Converting between hex and binary is easy, because each digit of a hexadecimal number "maps" to four bits (a bit being an individual binary digit) of a binary value.

Steps to convert from binary to hex which are actually done in the code above.

1.Split a binary value into groups of four, starting at the right-most side (which is obtained by (num & 15) in the above code)

2.For each group of four, check the "char[] map" to find the matching hex value, and replace groups of four binary digits with the one hex value

3.Right shift the input num by 4 bits and repeat step 2) until num becomes zero

4.Keep concatenating the values from 2) => and when num becomes zero -> it is the result
*/
class Solution {
    final char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0)
            return "0";
        StringBuilder ans = new StringBuilder();
        while(num != 0){//negative nums wont be considered when 'num > 0', hence give 'num != 0'
            ans.insert(0, hex[(num&15)]);//using the internal 2's complement repr 
            num >>>= 4;//to group every 4 digit
        }
        return ans.toString();
    }
}