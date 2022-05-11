// Code for Min Heap
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        // Construct an instance of Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add 3，1，2 respectively to the Min Heap
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        
        // Check all elements in the Min Heap, the result is [1, 3, 2]
        System.out.println("minHeap: " + minHeap.toString());
        
        // Get the top element of the Min Heap
        int peekNum = minHeap.peek();
        
        // The result is 1
        System.out.println("peek number: " + peekNum);
        
        // Delete the top element in the Min Heap
        int pollNum = minHeap.poll();
        
        // The reult is 1
        System.out.println("poll number: " + pollNum);
        
        // Check the top element after deleting 1, the result is 2
        System.out.println("peek number: " + minHeap.peek());
        
        // Check all elements in the Min Heap, the result is [2,3]
        System.out.println("minHeap: " + minHeap.toString());
        
        // Check the number of elements in the Min Heap
        // Which is also the length of the Min Heap
        int heapSize = minHeap.size();
        
        // The result is 2
        System.out.println("minHeap size: " + heapSize);
        
        // Check if the Min Heap is empty
        boolean isEmpty = minHeap.isEmpty();
        
        // The result is false
        System.out.println("isEmpty: " + isEmpty);
    }
}
