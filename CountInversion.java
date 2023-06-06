//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static long _merge(long[] arr, long[] mergedArr, int left, int mid, int right){
        long inversions = 0;
        int mergeIndex = left;
        int i = left, j = mid;
        while((i <= mid-1) && (j <= right)){
            if(arr[j] < arr[i]){
                mergedArr[mergeIndex++] = arr[j++];
                inversions = inversions + (mid-i);
            }else {
                mergedArr[mergeIndex++] = arr[i++];
            }
        }
        while(i <= mid-1){
            mergedArr[mergeIndex++] = arr[i++];
        }
        while(j <= right){
            mergedArr[mergeIndex++] = arr[j++];
        } 
        for(int index = left; index <= right; index++){
            arr[index] = mergedArr[index];
        }
        return inversions;
    }
    private static long _mergeSort(long[] arr, long[] temp, int left, int right){
        long inversions = 0;
        
        if(left < right){
            int mid = left + (right-left)/2;
            inversions += _mergeSort(arr, temp, left, mid);
            inversions += _mergeSort(arr, temp, mid+1, right);
            inversions += _merge(arr, temp, left, mid+1, right);
        }
        return inversions;
        
    }
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp = new long[(int)N];
        return _mergeSort(arr, temp, 0, (int)(N-1));
    }
}
