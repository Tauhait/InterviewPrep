class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int len = sb.length();
        int i = 0;
        int pos6 = -1;
        while(i < len && pos6 == -1){
            if(pos6 == -1 && sb.charAt(i) == '6')
                pos6 = i;
            // if(pos9 == -1 && sb.charAt(j) == '9')
            //     pos9 = j;
            // if(pos9 != -1 && pos6 != -1)
            //     break;
            i++;
            // j--;
        }
        // System.out.println(pos6+","+pos9);
        if(pos6 != -1)
            sb.setCharAt(pos6, '9');
        return Integer.parseInt(sb.toString());
    }
}