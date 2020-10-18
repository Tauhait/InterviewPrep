package faang;

public class PalindromicSubstrings {
    //Naive approach: Expand around center TC = O(n*n) SC = O(1)    
    /*
    public int countSubstrings(String s) {        
        int len = s.length(), ans = 0;
        //The middle of the palindrome could be in one of 2N - 1 positions: either at letter or between two letters.
        for(int center = 0; center <= 2*len - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }
    */
    // Optimal approach: Manacher's algorithm 
    // Manacher's Algo - Expanding around each centre makes the time complexity quadratic.
    /*
    Approach #2: Manacher's Algorithm [Accepted]
Intuition

Manacher's algorithm is a textbook algorithm that finds in linear time, the maximum size palindrome for any possible palindrome center. If we had such an algorithm, finding the answer is straightforward.

What follows is a discussion of why this algorithm works.

Algorithm

Our loop invariants will be that center, right is our knowledge of the palindrome with the largest right-most boundary with center < i, centered at center with right-boundary right. Also, i > center, and we've already computed all Z[j]'s for j < i.

When i < right, we reflect i about center to be at some coordinate j = 2 * center - i. Then, limited to the interval with radius right - i and center i, the situation for Z[i] is the same as for Z[j].

For example, if at some time center = 7, right = 13, i = 10, then for a string like A = '@#A#B#A#A#B#A#＄', the center is at the '#' between the two middle 'A''s, the right boundary is at the last '#', i is at the last 'B', and j is at the first 'B'.

Notice that limited to the interval [center - (right - center), right] (the interval with center center and right-boundary right), the situation for i and j is a reflection of something we have already computed. Since we already know Z[j] = 3, we can quickly find Z[i] = min(right - i, Z[j]) = 3.

Now, why is this algorithm linear? The while loop only checks the condition more than once when Z[i] = right - i. In that case, for each time Z[i] += 1, it increments right, and right can only be incremented up to 2*N+2 times.

Finally, we sum up (v+1) / 2 for each v in Z. Say the longest palindrome with some given center C has radius R. Then, the substring with center C and radius R-1, R-2, R-3, ..., 0 are also palindromes. Example: abcdedcba is a palindrome with center e, radius 4: but e, ded, cdedc, bcdedcb, and abcdedcba are all palindromes.

We are dividing by 2 because we were using half-lengths instead of lengths. For example we actually had the palindrome a#b#c#d#e#d#c#b#a, so our length is twice as big.

Cases:

Case 1: Do not pick a character as the new centre if the palindrome under it, is totally contained under current largest palindrome.
Case 2: If the current palindrome expands all the way upto the end of the input ther's no reason to proceed further.
Case 3: Pick a character as the centre if it expands all the way to the right edge and it's mirror palindrome expands all the way to the left edge of the current palindrome. Thus it's a proper prefix of the current palindrome.
Case 4: Do not pick a character as the new centre if it doesn't form as a proper prefix of the current palindrome. 


    
    public int countSubstrings(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c: S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        //right is our knowledge of the palindrome with the largest right-most boundary with center < i
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            
            if (i < right) Z[i] = Math.min(right - i, Z[2 * center - i]);
            
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1]) Z[i]++;
            
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z) ans += (v + 1) / 2;
        return ans;
    }
*/
    /*
    Simpler approach
    */
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += extractPalindrome(s, i, i);//odd length
            count += extractPalindrome(s, i, i + 1);//even length
        }
        return count;
    }
    public int extractPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--; right++;
            count++;
        }
        return count;
    }

}
