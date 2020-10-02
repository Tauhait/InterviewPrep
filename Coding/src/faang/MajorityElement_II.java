package faang;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement_II {
	//Brute force approach: Take each element and count its frequency, if its > floor(n/3) add it to the answer list. Then take the next element in the array and do the same thing - Time O(n*n)
    //Better approach: Use of hashmap - Time O(n lg n)
    //Optimal approach: Boyer Moore Voting Algo
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElemList = new ArrayList<Integer>();
        int majorElem1 = 0;
        int majorElem2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int elem : nums){
            if(majorElem1 == elem) ++count1;
            else if(majorElem2 == elem) ++count2;
            else if(count1 == 0) {
                majorElem1 = elem;
                count1 = 1;
            }else if(count2 == 0) {
                majorElem2 = elem;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }        
        }
        count1 = 0; count2 = 0;
        for(int elem : nums){
            if(majorElem1 == elem) count1++;
            if(majorElem2 == elem) count2++;
        }
        if(count1 > (int)(Math.floor(nums.length/3))) majorityElemList.add(majorElem1);
        if(count2 > (int)(Math.floor(nums.length/3))) if(!majorityElemList.contains(majorElem2)) majorityElemList.add(majorElem2);
        
        return majorityElemList;
    }

}
