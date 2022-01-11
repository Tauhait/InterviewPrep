class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //handle corner cases
        int totalPoints = 0;
        for(int point : cardPoints){
            totalPoints += point;
        }
        if(k == cardPoints.length){
            return totalPoints;
        }
        int toFind = cardPoints.length - k;
        int winLeft = 0, winRight;
        int winSum = 0;
        int miniSum = totalPoints;
        
        for(winRight = 0; winRight < cardPoints.length; winRight++){
            winSum += cardPoints[winRight];
            if((winRight - winLeft + 1) == toFind){
                miniSum = Math.min(miniSum, winSum);
                winSum -= cardPoints[winLeft];
                winLeft++;
            }
        }
        return totalPoints - miniSum;
    }
}