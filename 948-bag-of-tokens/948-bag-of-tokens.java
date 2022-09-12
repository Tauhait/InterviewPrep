class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int low = 0, high = tokens.length-1;
        int score = 0;
        while(low <= high){
            if(power >= tokens[low]){
                score++;
                power -= tokens[low];
                low++;
            }else {
                if(score >= 1 && high - low > 1){
                    power += tokens[high];
                    score -= 1;
                    high--;
                }else {
                    break;
                }
            }
        }
        return score;
    }
}