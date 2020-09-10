package Amazon;
/*
We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and 
the remaining numbers are in the second array. Extra space allowed in O(1).
Example:

Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20} 
 */
public class MergeSortedArray {
	/*Method 1
	1) Iterate through every element of ar2[] starting from last 
		element. Do following for every element ar2[i]
		 a) Store last element of ar1[i]: last = ar1[i]
		 b) Loop from last element of ar1[] while element ar1[j] is 
		    greater than ar2[i].
		       ar1[j+1] = ar1[j] // Move element one position ahead
		       j--
		 c) If any element of ar1[] was moved or (j != m-1)
		       ar1[j+1] = ar2[i] 
		       ar2[i] = last  
	The worst case time complexity of code/algorithm is O(m*n). The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
	<!— Initial Arrays:
		ar1[] = {1, 5, 9, 10, 15, 20};
		ar2[] = {2, 3, 8, 13};
		
		After First Iteration:
		ar1[] = {1, 5, 9, 10, 13, 15};
		ar2[] = {2, 3, 8, 20};
		// 20 is moved from ar1[] to ar2[]
		// 13 from ar2[] is inserted in ar1[]
		
		After Second Iteration:
		ar1[] = {1, 5, 8, 9, 10, 13};
		ar2[] = {2, 3, 15, 20};
		// 15 is moved from ar1[] to ar2[]
		// 8 from ar2[] is inserted in ar1[]
		
		After Third Iteration:
		ar1[] = {1, 3, 5, 8, 9, 10};
		ar2[] = {2, 13, 15, 20};
		// 13 is moved from ar1[] to ar2[]
		// 3 from ar2[] is inserted in ar1[]
		
		
		
		
		After Fourth Iteration:
		ar1[] = {1, 2, 3, 5, 8, 9};
		ar2[] = {10, 13, 15, 20};
		// 10 is moved from ar1[] to ar2[]
		// 2 from ar2[] is inserted in ar1[]
	—!>
	*/
	/*Method 2
	 we need to merge them in O((n+m)*log(n+m)) time with O(1) extra space into a sorted array, when n is the size of the first array, and m is the size of the second array.
	 The idea: we start comparing elements that are far from each other rather than adjacent.
	 For every pass, we calculate the gap and compare the elements towards the right of the gap. Every pass, the gap reduces to the ceiling value of dividing by 2.
	 
	 First example: a1[] = {3 27 38 43}, a2[] = {9 10 82}
		Start with gap =  ceiling of n/2 = 4 [This gap is for whole merged array]
        3 27 38 43   9 10 82 
        3 27 38 43   9 10 82
        3 10 38 43   9 27 82
        gap = 2:
        3 10 38 43   9 27 82
        3 10 38 43   9 27 82
        3 10 38 43   9 27 82 
        3 10 9 43   38 27 82
        3 10 9 27   38 43 82
        gap = 1:
        3 10 9 27   38 43 82
        3 10 9 27   38 43 82
        3 9 10 27   38 43 82
        3 9 10 27   38 43 82
        3 9 10 27   38 43 82
        3 9 10 27   38 43 82
		Output : 3 9 10 27 38 43 82
		
		Second Example: a1[] = {10 27 38 43 82}, a2[] = {3 9}
		Start with gap = ceiling of n/2 (4):
		10 27 38 43 82   3 9 
		10 27 38 43 82   3 9
		10 3 38 43 82   27 9
		10 3 9 43 82   27 38
		gap = 2:
		10 3 9 43 82   27 38
		9 3 10 43 82   27 38
		9 3 10 43 82   27 38
		9 3 10 43 82   27 38
		9 3 10 27 82   43 38
		9 3 10 27 38   43 82
		gap = 1
		9 3 10 27 38   43 82
		3 9 10 27 38   43 82
		3 9 10 27 38   43 82
		3 9 10 27 38   43 82
		3 9 10 27 38   43 82
		3 9 10 27 38   43 82
		Output : 3 9 10 27 38   43 82
	 
	 */
	 // Reducing the gap by a factor of 2  
	
    private int nextGap(int gap) {  
        if (gap <= 1)  return 0;  
        return (int)((gap / 2) + (gap % 2));  
    }
    public void sortByGapMethod(int arr[]) {
    	int n = arr.length;
    	for (int gap = nextGap(n); gap > 0; gap = nextGap(gap)) // log N
	      for (int i = 0; i + gap < n; i++)  // N
	        if (arr[i] > arr[i + gap]) swap(arr, i, i + gap);
        
    }
    private void swap(int[] arr, int first, int second) {
    	int temp = arr[first];
    	arr[first] = arr[second];
    	arr[second] = temp;
    }
    @SuppressWarnings("unused")
	private void bitonic(int[] arr1, int[] arr2) { //A sequence is said to be bitonic if it is first increasing and then decreasing
		// Form both arrays to be bitonic  
		int n = arr1.length, m = arr2.length;
		int x = Math.min(n, m);
	    for (int i = 0; i < x; i++) {  
	        if (arr1[n-i-1] > arr2[i]) { 
	            // swap(arr1[n - i - 1], arr2[i]);  
	            int temp = arr1[n-i-1]; 
	            arr1[n-i-1] = arr2[i]; 
	            arr2[i] = temp; 
	        } 
	    }      
    }

}
