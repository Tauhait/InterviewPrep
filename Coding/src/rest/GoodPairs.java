package rest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GoodPairs {
	/*
    Best Soln
    */
    // public int numIdenticalPairs(int[] A) {
    //     int res = 0, count[] = new int[101];
    //     for (int a: A) {
    //         res += count[a]++;
    //     }
    //     return res;
    // }
    
    /*
    Naive Soln
    */
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        Map<Integer, List<Integer>> goodPairMap = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<nums.length; i++){
            if(!goodPairMap.containsKey(nums[i])){
                goodPairMap.put(nums[i], new LinkedList<Integer>());
            }
            goodPairMap.get(nums[i]).add(i);
        }
        Iterator<Integer> mapKeyIter = goodPairMap.keySet().iterator();
        while(mapKeyIter.hasNext()){
            int len = goodPairMap.get(mapKeyIter.next()).size();
            if(len > 1){
                goodPairs += (len*(len-1)/2);
            }
        }
        return goodPairs;
    }

}
