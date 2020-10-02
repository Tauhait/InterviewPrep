package faang;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class K_FreqElems {
	public int[] topKFrequent(int[] nums, int k) {        
        if (k == nums.length) return nums;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int elem : nums) freqMap.put(elem, freqMap.getOrDefault(elem, 0) + 1);
        Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> freqMap.get(n2) - freqMap.get(n1));
        for (int n: freqMap.keySet()) maxHeap.add(n);
        int[] topKfreq = new int[k];
        while(k-- > 0) topKfreq[k] = maxHeap.poll();
        return topKfreq;
    }
}
