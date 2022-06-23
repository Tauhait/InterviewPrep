class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b-a);
        int time = 0;
        for(int[] course : courses){
            if(time + course[0] <= course[1]) {
                time += course[0];
                maxHeap.offer(course[0]);
            }else if(!maxHeap.isEmpty() && course[0] < maxHeap.peek()){ 
                time += course[0] - maxHeap.poll();
                maxHeap.offer(course[0]);
            }else ;//can't include this course            
        }
        return maxHeap.size();
    }
}