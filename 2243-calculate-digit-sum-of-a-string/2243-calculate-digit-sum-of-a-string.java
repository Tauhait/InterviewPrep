class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i += k){
                int t = 0;
                for(int j = i; j < i + k && j < s.length(); j++){
                    t += s.charAt(j) - '0';
                }
                sb.append(t);
            }
            s = sb.toString();
        }
        return s;
    }
}