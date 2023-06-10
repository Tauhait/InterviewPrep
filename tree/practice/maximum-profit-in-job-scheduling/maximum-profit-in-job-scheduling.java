class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> jobs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            jobs.add(new int[]{startTime[i],endTime[i],profit[i]});
        }
        Collections.sort(jobs, (A,B)->(A[0]-B[0]));//sorted by startTime incr order
        PriorityQueue<int[]> pq = new PriorityQueue<>((A,B)->(A[0]-B[0]));//sorted by endTime incr order
        
        int maxProfit = 0;
        for(int[] job : jobs){
            //poll all valid intervals and get max profit among them
            while(!pq.isEmpty() && job[0] >= pq.peek()[0]){
                maxProfit = Math.max(maxProfit, pq.poll()[1]);
            }
            //new entry of a maxprofit including current element
            pq.add(new int[]{job[1], job[2]+maxProfit});
        }
        //poll all intervals and get max profit
        while(!pq.isEmpty()){
            maxProfit = Math.max(maxProfit, pq.poll()[1]);
        }
        return maxProfit;        
    }
}