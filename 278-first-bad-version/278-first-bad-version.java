/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0, high = n;
        while(low < high){
            int mid = (low + high) >>> 1;
            if(isBadVersion(mid)) high = mid;
            else low = mid + 1;
        }
        return high;        
    }
}