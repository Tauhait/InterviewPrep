class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();
        for(String word : word1){
            A.append(word);
        }
        for(String word : word2){
            B.append(word);
        }
        // System.out.println(A+","+B);
        return A.toString().equals(B.toString());
    }
}