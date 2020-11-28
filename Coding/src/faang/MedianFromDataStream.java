package faang;

import java.util.PriorityQueue;

public class MedianFromDataStream {
	class MedianFinder {
	    PriorityQueue<Integer> maxHeap;//first heap
	    PriorityQueue<Integer> minHeap;//second heap

	    /** initialize your data structure here. */
	    public MedianFinder() {
	        minHeap = new PriorityQueue<Integer>();
	        maxHeap = new PriorityQueue<Integer>((a,b)->(b - a));
	    }
	    
	    public void addNum(int num) {
	        maxHeap.offer(num);
	        minHeap.offer(maxHeap.peek());
	        maxHeap.poll();
	        if(minHeap.size() > maxHeap.size()){
	            maxHeap.offer(minHeap.peek());
	            minHeap.poll();
	        }
	    }
	    public double findMedian() {
	        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek())/2.0;
	    }
	}

	/**
	 * Your MedianFinder object will be instantiated and called as such:
	 * MedianFinder obj = new MedianFinder();
	 * obj.addNum(num);
	 * double param_2 = obj.findMedian();
	 */

}
