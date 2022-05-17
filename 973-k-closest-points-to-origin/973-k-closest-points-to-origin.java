class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Map<String, Integer> pointDistMap = new HashMap();
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
            (a, b) -> {
                String B = b[0] + "," + b[1];
                String A = a[0] + "," + a[1];
                return (int)(pointDistMap.get(B) - pointDistMap.get(A));
            }
        );
        for(int[] point : points){
            String p = point[0] + "," + point[1];
            int dist = (int)(Math.pow(point[0],2) + Math.pow(point[1],2));
            pointDistMap.put(p, dist);            
            maxHeap.add(point);
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