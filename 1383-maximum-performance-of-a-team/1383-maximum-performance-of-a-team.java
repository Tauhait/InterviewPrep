class Solution {
    /**
    For each candidate, we treat him/her as the one who has the minimum efficiency in a team.
    Then, we select the rest of the team members based on this condition.
    
    First of all, let's sort the candidates by efficiency in descending order.
    Then, we will iterate through the sorted candidates.
    At each iteration, our goal is to construct a team with at most k members, 
    while treating the current candidate as the one with the lowest efficiency on the team.
    We use a priority queue to store the speeds for the rest k-1 team members. 
    The priority queue is maintained as a sliding window along with our iteration. 
    For example, we pop out the member with the lowest speed 
    when we exceed the predefined capacity of the queue, which is k-1.
    */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = 1_000_000_007;
        // build tuples of (efficiency, speed)
        List<Pair<Integer, Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        // sort the members by their efficiencies
        Collections.sort(candidates, (a,b)->(b.getKey()-a.getKey()));

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (Pair<Integer, Integer> p : candidates) {
            Integer currEfficiency = p.getKey();
            Integer currSpeed = p.getValue();
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }
}