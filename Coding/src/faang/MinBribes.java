package faang;

import java.util.ArrayList;
import java.util.List;

public class MinBribes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> q = new ArrayList<Integer>();
//		q.add(4);
//		q.add(1);
//		q.add(2);
//		q.add(3);
		q.add(2);
		q.add(1);
		q.add(5);
		q.add(3);
		q.add(4);
		minimumBribes(q);

	}
	public static void minimumBribes(List<Integer> q) {
    	// Write your code here
        int swaps = 0;
        int n = q.size();
        for(int i=n-1; i>=0; i--) {
            if(q.get(i) != (i+1)){
                if((i-1) >= 0 && q.get(i-1) == (i+1)){
                    swaps++;	                    
                    int temp = q.get(i-1);
                    q.set(i-1, q.get(i));
                    q.set(i, temp);
                }else if((i-2) >= 0 && q.get(i-2) == (i+1)){
                    swaps += 2;
                    int temp = q.get(i-2);
                    q.set(i-2, q.get(i-1));
                    q.set(i-1, q.get(i));
                    q.set(i, temp);
                }else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }
	    
}
