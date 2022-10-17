class Solution {
    public boolean checkIfPangram(String sentence) {
        int seen = 0;
        for(char c : sentence.toCharArray()){
            int shift = c-'a';
            seen |= (1<<shift);
        }
        return (seen + 1 == (1<<26));
    }
}