class Solution {
    private final int D = 26;
    private final int Q = 997;
    
    private List<Integer> rabinKarpMatch(String pat, String str)
    {
        // your code here
        int M = pat.length();
        int N = str.length();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        long H = ((long)Math.pow(D, M - 1)) % Q;
        long hashPat = 0;
        long hashStr = 0;
        for(int i = 0; i < M; i++) {
            hashPat = (D * hashPat + pat.charAt(i)) % Q;
            hashStr = (D * hashStr + str.charAt(i)) % Q;
        }
        
        for(int i = 0; i < N; i++){
            if(hashStr == hashPat){
                String substr = str.substring(i, Math.min(i + M, N));
                if(substr.equals(pat)){
                    indexes.add(i);
                }
            }            
            if(i < N - M){
                hashStr = (hashStr + Q - str.charAt(i) * H % Q) % Q;
                hashStr = (hashStr * D + str.charAt(i + M)) % Q;
            }
        }
        if(indexes.isEmpty()) {
            indexes.add(-1);
        }
        return indexes;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        List<Integer> indexes = rabinKarpMatch(needle, haystack);
        for(int index : indexes){
            System.out.print(index + " ");
        }
        return indexes.get(0);
    }
}