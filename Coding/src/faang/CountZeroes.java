package faang;
//https://www.geeksforgeeks.org/find-number-zeroes/
public class CountZeroes {
	int countZeroes(int[] arr, int n) {
        int low = 0, high = n - 1;
        int zeroLoc = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 0) { zeroLoc = mid; high = mid - 1; }
            else low = mid + 1; 
        }
        return zeroLoc > n || zeroLoc < 0 ? 0 : n - zeroLoc;
    }
}
