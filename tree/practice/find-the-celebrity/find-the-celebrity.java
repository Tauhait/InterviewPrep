/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int n;
    private Map<Pair<Integer,Integer>, Boolean> pairKnowsMap = new HashMap<>();
    
    @Override
    public boolean knows(int a, int b){
        Pair<Integer,Integer> pairAB = new Pair<>(a, b);
        if( pairKnowsMap.containsKey(pairAB)){
            return pairKnowsMap.get(pairAB);
        } else {
            boolean doesAKnowB = super.knows(a, b);
            pairKnowsMap.put(pairAB, doesAKnowB);
            return doesAKnowB;
        }
    }

    private boolean isCelebrity(int celebrityCandidate){
        for(int i = 0; i < n; i++){
            if(i == celebrityCandidate) continue;
            else {
                if( knows(celebrityCandidate, i) || 
                    !knows(i, celebrityCandidate)){
                        return false;
                }
            }
        }
        return true;
    }

    public int findCelebrity(int n) {
        this.n = n;
        int celebrityCandidate = 0;
        for(int i = 0; i < n; i++){
            if(knows(celebrityCandidate, i)){
                celebrityCandidate = i;
            }
        }
        return isCelebrity(celebrityCandidate) ? celebrityCandidate : -1;
    }
}