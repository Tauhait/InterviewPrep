/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high){
            int mid = (low + high) >>> 1;
            int guessRes = guess(mid);
            if(guessRes == 1) low = mid + 1;
            else if(guessRes == -1) high = mid - 1;
            else return mid;
        }
        return -1;
    }
}