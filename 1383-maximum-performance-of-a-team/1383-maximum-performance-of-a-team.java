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
    
    
    Performance = sum(speed) * min(efficiency). 
    Idea is simple: try every efficiency value from highest to lowest and 
    at the same time maintain an as-large-as-possible speed group, 
    keep adding speed to total speed, 
    if size of engineers group exceeds K, lay off the engineer with lowest speed.
    
    Sort efficiency with descending order. Because, afterwards, 
    when we iterate whole engineers, every round,
    when calculating the current performance, 
    minimum efficiency is the effiency of the new incoming engineer.
    
    Maintain a pq to track of the minimum speed in the group. 
    If size of group is == K, 
    kick the engineer with minimum speed out
    (since efficiency is fixed by new coming engineer, 
    the only thing matters now is sum of speed).
    
    Calculate/Update performance.
    */
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i) 
            engineers[i] = new int[] {efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            // min efficiency is the efficiency of new engineer
            res = Math.max(res, (totalSpeed * engineer[0]));  
        }

        return (int) (res % MOD);
    }
}