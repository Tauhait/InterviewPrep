package rest;

import java.util.Arrays;

//https://www.geeksforgeeks.org/counting-inversions/
//Count Inversions in an array | Set 1 (Using Merge Sort)
//Last Updated: 11-06-2020
//Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
//Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
//
//Example:
//
//Input: arr[] = {8, 4, 2, 1}
//Output: 6
//
//Explanation: Given array has six inversions:
//(8,4), (4,2),(8,2), (8,1), (4,1), (2,1).
//
//
//Input: arr[] = {3, 1, 2}
//Output: 2
//
//Explanation: Given array has two inversions:
//(3, 1), (3, 2) 
//METHOD 1 (Simple) Time O(N*N)
//
//Approach :Traverse through the array and for every index find the number of smaller elements on its right side of the array. This can be done using a nested loop. Sum up the counts for all index in the array and print the sum.
//Algorithm :
//Traverse through the array from start to end
//For every element find the count of elements smaller than the current number upto that index using another loop.
//Sum up the count of inversion for every index.
//Print the count of inversions.

//METHOD 2(Enhance Merge Sort) Time O(N log N)
//
//Approach:
//Suppose the number of inversions in the left half and right half of the array (let be inv1 and inv2), what kinds of inversions are not accounted for in Inv1 + Inv2? 
//The answer is – the inversions that need to be counted during the merge step. Therefore, to get a number of inversions, 
//		that needs to be added a number of inversions in the left subarray, right subarray and merge().
//		How to get number of inversions in merge()?
//		In merge process, let i is used for indexing left sub-array and j for right sub-array. At any step in merge(), 
//		if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, 
//		so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]

//		Algorithm:
//		1. The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.
//		2. Create a function merge that counts the number of inversions when two halves of the array are merged, create two indices i and j, 
//			i is the index for first half and j is an index of the second half. if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
//		3. Create a recursive function to divide the array into halves and find the answer by summing the number of inversions is the first half, 
//			number of inversion in the second half and the number of inversions by merging the two.
//		4. The base case of recursion is when there is only one element in the given half.
//		5. Print the answer

//Note that above code modifies (or sorts) the input array. If we want to count only inversions 
//then we need to create a copy of original array and call mergeSort() on copy.
public class CountInversionsUsingMergeSort {
	public int getInvCountUsingNestedLoop(int[] arr, int n) { 
	    int inv_count = 0; 
	    for (int i = 0; i < n - 1; i++) 
	        for (int j = i + 1; j < n; j++) 
	            if (arr[i] > arr[j]) 
	                inv_count++;
	    return inv_count; 
	}
	private int mergeAndCount(int[] arr, int l, int m, int r) { 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
  
    // Merge sort function 
    @SuppressWarnings("unused")
	private int mergeSortAndCount(int[] arr, int l, int r) 
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        int count = 0; 
  
        if (l < r) { 
            int m = (l + r) / 2; 
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    } 

}
