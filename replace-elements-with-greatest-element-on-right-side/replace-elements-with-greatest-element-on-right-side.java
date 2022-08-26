class Solution {
    public int[] replaceElements(int[] arr) {
        int greatestRight = 0, prevElem = arr[arr.length-1];
        for(int i = arr.length-1; i >= 0; i--){            
            if(i == arr.length-1) arr[i] = -1;
            else {                
                greatestRight = Math.max(greatestRight, prevElem);
                prevElem = arr[i];
                arr[i] = greatestRight;
            }                
        }
        return arr;
    }
}