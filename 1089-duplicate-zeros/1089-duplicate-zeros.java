class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] countZeros = new int[n];
        for(int i = 1; i < n; i++){
            if(arr[i-1] == 0){
                countZeros[i] = countZeros[i-1] + 1;
            }
            else {
                countZeros[i] = countZeros[i-1];
            }
        }
        for(int i = n-1; i >= 0; i--){
            int shift = countZeros[i];
            if(shift == 0) continue;
            int copy = arr[i];
            arr[i] = 0;
            if(i+shift >= n) continue;
            arr[i+shift] = copy;
        }
    }
}
// [1,0,2,3,0,4,5,0]
// [0,0,1,1,1,2,2,2]
// [1,0,0,2,3,0,0,4]