package rest;

public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
        boolean isIncr = false;
        int index = 0;
        while(index + 1 < A.length && A[index] == A[index + 1]) index++;
        if(index == A.length - 1) return true;
        isIncr = A[index] > A[index + 1] ? false : true;
        int prev = A[0];
        for( ; index < A.length; index++) {
            int elem = A[index];
            if(isIncr) {
                if(elem < prev) return false;
            }
            else { 
                if(elem > prev) return false;
            }
            prev = elem;
        }
        return true;
    }

}
