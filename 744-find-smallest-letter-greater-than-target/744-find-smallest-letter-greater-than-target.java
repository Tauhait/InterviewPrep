class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while(low < high){
            int mid = (low + high) >>> 1;
            if(letters[mid] > target) high = mid;
            else low = mid + 1;
        }
        return target >= letters[high] ? letters[0] : letters[high];
    }
}