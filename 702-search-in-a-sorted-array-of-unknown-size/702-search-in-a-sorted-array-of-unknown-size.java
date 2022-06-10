/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = getSize(reader);
        System.out.println(right);
        
        while(left <= right){
            int mid = (left + right) >>> 1;
            int val = reader.get(mid);
            if(val == target) return mid;
            else if(val < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    private int getSize(ArrayReader reader){
        int i = 1;
        while(reader.get(i + 1) != Integer.MAX_VALUE){
            if(reader.get(i) != Integer.MAX_VALUE) i <<= 1;
            else i >>= 1;
        }
        return i;
    }
}