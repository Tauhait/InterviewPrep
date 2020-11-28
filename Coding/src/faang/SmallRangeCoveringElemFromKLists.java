package faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SmallRangeCoveringElemFromKLists {
	public int[] smallestRange(List<List<Integer>> nums) {
        if(nums.isEmpty()) return new int[1];
        int k = nums.size();
        HashMap<Integer, Integer> mergeMap = new HashMap<Integer, Integer>();
        int[] index = new int[k];
        while(true){
            int currMin = Integer.MAX_VALUE;
            int currMinIndex = -1;
            for(int i = 0; i < k; i++){
                if(index[i] < nums.get(i).size() && nums.get(i).get(index[i]) < currMin){
                    currMin = nums.get(i).get(index[i]);
                    currMinIndex = i;
                }
            }
            if(currMinIndex != -1){
                index[currMinIndex]++;
                mergeMap.put(currMinIndex + 1, currMin);
            }else break;
        }
        Iterator<Integer> kMergeIter = mergeMap.values().iterator();
        ArrayList<Integer> copyList = new ArrayList<Integer>();
        while(kMergeIter.hasNext()) {
        	copyList.add(kMergeIter.next());
        }
        int[] range = new int[2];
        
        return range;
    }
	public static void main(String[] args) {
		SmallRangeCoveringElemFromKLists test = new SmallRangeCoveringElemFromKLists();
		List<List<Integer>> klists = new ArrayList<List<Integer>>();
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<Integer> listC = new ArrayList<Integer>();
		listA.add(4);
		listA.add(10);
		listA.add(15);
		listA.add(24);
		listA.add(26);
		
		listB.add(0);
		listB.add(9);
		listB.add(12);
		listB.add(20);
		
		listC.add(5);
		listC.add(18);
		listC.add(22);
		listC.add(30);
		
		klists.add(listA);
		klists.add(listB);
		klists.add(listC);
		
		int[] range = test.smallestRange(klists);
	}

}
