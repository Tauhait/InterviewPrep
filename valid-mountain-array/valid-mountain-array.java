class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;
        int mountainPeak = -1;
        for(int i = 1; i < n; i++){
            if(arr[i-1] == arr[i]) return false;
            else if(arr[i-1] > arr[i]) {
                mountainPeak = i-1;
                break;
            }
            mountainPeak = i;
        }
        if(mountainPeak == 0 || mountainPeak == n-1) return false;
        for(int i = mountainPeak+1; i+1 < n; i++){
            if(arr[i] == arr[i+1] || arr[i] < arr[i+1]) return false;
        }
        return true;
    }
}