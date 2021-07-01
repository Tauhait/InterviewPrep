package faang;

public class SumOddLenSubArr {
    /*
Optimal
    
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for(int i=0;i < arr.length; i++)
            ans += ((((arr.length-i) * (i+1)) + 1 )/2) * arr[i];
        return ans;
    }
    
Solution : Consider the contribution of A[i]
Also suggested by @mayank12559 and @simtully.

Consider the subarray that contains A[i],
we can take 0,1,2..,i elements on the left,
from A[0] to A[i],
we have i + 1 choices.

we can take 0,1,2..,n-1-i elements on the right,
from A[i] to A[n-1],
we have n - i choices.

In total, there are k = (i + 1) * (n - i) subarrays, that contains A[i].
And there are (k + 1) / 2 subarrays with odd length, that contains A[i].
And there are k / 2 subarrays with even length, that contains A[i].

A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times for our question.


Example of array [1,2,3,4,5]
1 2 3 4 5 subarray length 1
1 2 X X X subarray length 2
X 2 3 X X subarray length 2
X X 3 4 X subarray length 2
X X X 4 5 subarray length 2
1 2 3 X X subarray length 3
X 2 3 4 X subarray length 3
X X 3 4 5 subarray length 3
1 2 3 4 X subarray length 4
X 2 3 4 5 subarray length 4
1 2 3 4 5 subarray length 5

5 8 9 8 5 total times each index was added, k = (i + 1) * (n - i)
3 4 5 4 3 total times in odd length array with (k + 1) / 2
2 4 4 4 2 total times in even length array with k / 2s


Complexity
Time O(N)
Space O(1)

    */
    //Ref: https://web.stanford.edu/class/cs9/sample_probs/SubarraySums.pdf
    
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int oddSum = arr[0];
        if(n == 1){
            return oddSum;
        }
        
        for(int i = 1; i < n; i++){
            oddSum += arr[i];
            arr[i] += arr[i-1];
        }
        if(n % 2 == 1){
            oddSum += arr[n-1];
        }
        
        for(int i = 3; i < n; i += 2){
            for(int j = i-1; j < n; j++){
                if(j == (i-1)){
                    oddSum += arr[j];
                }else {
                    oddSum += (arr[j] - arr[j-i]);
                }
            }
        }
        return oddSum;
    }

}
