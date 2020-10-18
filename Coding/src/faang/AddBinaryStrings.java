package faang;

public class AddBinaryStrings {
	public String addBinary(String a, String b) {
		int maxLen = Math.max(a.length(), b.length());
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        while(sb1.length() != maxLen) sb1.insert(0, "0");
        while(sb2.length() != maxLen) sb2.insert(0, "0");
        int carry = 0;
        while(--maxLen >= 0){
            int sum = (sb1.charAt(maxLen) - '0') + (sb2.charAt(maxLen) - '0') + carry;            
            carry = sum / 2;
            sb1.setCharAt(maxLen, sum % 2 == 0 ? '0' : '1');
        }
        if(carry == 1) sb1.insert(0, '1');
        return sb1.toString();
    }
	public String addBinary_OPT(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() -1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry 
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }
}
