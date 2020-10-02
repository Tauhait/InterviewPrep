package rest;

public class FindMissingAndDuplicate {
	/*
	 * Find the repeating and the missing
	 * Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. 
	 * Find these two numbers.
	 * 	Input: arr[] = {3, 1, 3}
		Output: Missing = 2, Repeating = 3
		Explanation: In the array, 
		2 is missing and 3 occurs twice 
		
		Input: arr[] = {4, 3, 6, 2, 1, 1}
		Output: Missing = 5, Repeating = 1
		================================================================================================================================================
		Method 1 (Use Sorting)
		Approach:		
		Sort the input array.
		Traverse the array and check for missing and repeating.
		Time Complexity: O(nLogn)
		================================================================================================================================================
		Method 2 (Use count array)
		Approach:		
		Create a temp array temp[] of size n with all initial values as 0.
		Traverse the input array arr[], and do following for each arr[i]
		if(temp[arr[i]] == 0) temp[arr[i]] = 1;
		if(temp[arr[i]] == 1) output “arr[i]” //repeating
		Traverse temp[] and output the array element having value as 0 (This is the missing element)
		Time Complexity: O(n)
		Auxiliary Space: O(n)
		================================================================================================================================================
		Method 3 (Use elements as Index and mark the visited places)
		Approach:
		Traverse the array. While traversing, use the absolute value of every element as an index and make the value at this index as negative to mark it visited. 
		If something is already marked negative then this is the repeating element. To find missing, traverse the array again and look for a positive value.
		================================================================================================================================================
		Method 4 (Make two equations)
		Approach:				
		Let x be the missing and y be the repeating element.
		Get the sum of all numbers using formula S = n(n+1)/2 – x + y
		Get product of all numbers using formula P = 1*2*3*…*n * y / x
		The above two steps give us two equations, we can solve the equations and get the values of x and y.
		Time Complexity: O(n)		
		Note: This method can cause arithmetic overflow as we calculate product and sum of all array elements.
		================================================================================================================================================
		Method 5 (Use XOR)
		Approach:	
		Let x and y be the desired output elements.
		Calculate XOR of all the array elements.
		xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]		
		XOR the result with all numbers from 1 to n
		xor1 = xor1^1^2^…..^n		
		In the result xor1, all elements would nullify each other except x and y. 
		All the bits that are set in xor1 will be set in either x or y. 
		So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and 
		divide the elements of the array in two sets – one set of elements with same bit set and 
		other set with same bit not set. By doing so, we will get x in one set and y in another set. 
		Now if we do XOR of all the elements in first set, we will get x, and by doing same in other set we will get y..
		Time Complexity: O(n)
		This method doesn’t cause overflow, 
		but it doesn’t tell which one occurs twice and which one is missing. 
		We can add one more step that checks which one is missing and which one is repeating. This can be easily done in O(n) time.
		================================================================================================================================================
		Method 6 (Use a Map)
		Approach:
		This method involves creating a Hashtable with the help of Map. 
		In this, the elements are mapped to their natural index. 
		In this process, if an element is mapped twice, then it is the repeating element.
		And if an element’s mapping is not there, then it is the missing element.
		================================================================================================================================================
		Method 7 (Make two equations using sum and sum of squares)
		Approach:		
		Let x be the missing and y be the repeating element.
		Let N is the size of array.
		Get the sum of all numbers using formula S = N(N+1)/2
		Get product of all numbers using formula Sum_Sq = N(N+1)(2N+1)/6
		Iterate through a loop from i=1….N
		S -= A[i]
		Sum_Sq -= (A[i]*A[i])
		It will give two equations
		x-y = S – (1)
		x^2 – y^2 = Sum_sq
		x+ y = (Sum_sq/S) – (2)		
		Time Complexity: O(n)
		Note: This method can cause arithmetic overflow as we calculate product and sum of all array elements.
	 */
	public int[] findMissingAndDuplicate(int[] nums) {//Method 5 (Use XOR)
		int[] ans = new int[2];		
		int xor = nums[0], size = nums.length;
		for(int i = 1; i < size; i++) xor ^= nums[i];
		for(int i = 1; i <= size; i++) xor ^= i;
		//xor = missing ^ duplicate 
		int rightmostSetBitPos = xor & ~(xor - 1);// number & 2's complement(number) gives the right most set bit of xor
		//rightmost bit position which is different for missing and duplicate 
		int bucket1 = 0, bucket2 = 0;
		//Divide the array elements into two buckets
		for(int ele : nums) {
			if((rightmostSetBitPos & ele) != 0) bucket1 ^= ele;
			else bucket2 ^= ele;
		}
		//Divide the range (1..size) into these buckets which will fetch the missing numbers 
		for(int i = 1; i <= size; i++) {
			if((rightmostSetBitPos & i) != 0) bucket1 ^= i;
			else bucket2 ^= i;
		}
		System.out.println(bucket1 + "," + bucket2);
		//The numbers in bucket1 and bucket2 are either the missing or duplicate numbers
		for(int ele : nums) {
			if(ele == bucket1) {
				//System.out.println("Missing: " + bucket2 + "|| Duplicate: " + bucket1);
				ans[0] = bucket2; ans[1] = bucket1;
				break;
			}
			if(ele == bucket2) {
				// System.out.println("Missing: " + bucket1 + "|| Duplicate: " + bucket2);
				ans[0] = bucket1; ans[1] = bucket2;
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		FindMissingAndDuplicate obj = new FindMissingAndDuplicate();
//		int[] ans = obj.findMissingAndDuplicate(new int[]{ 4, 3, 6, 2, 1, 1 });
		int[] ans = obj.findMissingAndDuplicate(new int[]{ 1, 3, 4, 5, 1, 6, 2 });
//		int[] ans = obj.findMissingAndDuplicate(new int[]{ 3, 1, 3 });
		System.out.println("Missing: " + ans[0] + "|| Duplicate: " + ans[1]);
	}
}
