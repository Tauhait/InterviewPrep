package faang;

import java.util.ArrayList;
import java.util.List;

public class Find_K_Closest_Elems {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(k == arr.length){
            for(int i = 0; i < k; i++){
                result.add(arr[i]);
            }
            return result;
        }
        int low = 0, high  = arr.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(x < arr[mid]){
                high = mid - 1;
            }else if(x > arr[mid]){
                low = mid + 1;
            }else {
                break;
            }
        }
        // Initialize our sliding window's bounds
        int leftPtr = Math.max(0, mid - 1);
        int rightPtr = leftPtr + 1;
        // While the window size is less than k
        while((rightPtr - leftPtr - 1) < k){
            if(leftPtr == -1){//if no more elements to the left keep moving right
                rightPtr += 1;
                continue;
            }
            // Expand the window towards the side with the closer number
            if(rightPtr == arr.length || Math.abs(arr[leftPtr] - x) <= Math.abs(arr[rightPtr] - x)){
                leftPtr -= 1;
            }else {
                rightPtr += 1;
            }
        }
        for(int i = leftPtr + 1; i < rightPtr; i++){
            result.add(arr[i]);
        }
        return result;
    }

}
