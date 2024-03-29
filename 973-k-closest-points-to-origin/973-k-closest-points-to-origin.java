class Solution {
    public int[][] kClosest(int[][] points, int k) {        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> (b[2] - a[2]));
        for(int[] point : points){
            int dist = (int)(Math.pow(point[0],2) + Math.pow(point[1],2));
            maxHeap.add(new int[]{point[0], point[1], dist});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] results = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] result = maxHeap.poll();
            results[i][0] = result[0];
            results[i][1] = result[1];
        }
        return results;
    }
}