package rest;

public class MajorityElement {
	//Brute force: pick one element and count the no of occurences of it in the array. If it is more than floor(n/2) and return it - Time = O(n*n), Space = O(1)
    //Better:  Use of hashmap - Time = O(n lg n) if hashmap is NOT a freq array, Space = O(n)
    //Optimal: Moore Voting Algo 
    /*
Approach: This is a two-step process.
The first step gives the element that maybe the majority element in the array. If there is a majority element in an array, then this step will definitely return majority element, otherwise, it will return candidate for majority element.
Check if the element obtained from the above step is majority element. This step is necessary as there might be no majority element.

Step 1: Finding a Candidate
The algorithm for the first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is that if each occurrence of an element e can be cancelled with all the other elements that are different from e then e will exist till end if it is a majority element.

Step 2: Check if the element obtained in step 1 is majority element or not.
Traverse through the array and check if the count of the element found is greater than half the size of the array, then print the answer else print “No majority element”.

Algorithm:
Loop through each element and maintains a count of majority element, and a majority index, maj_index
If the next element is same then increment the count if the next element is not same then decrement the count.
if the count reaches 0 then changes the maj_index to the current element and set the count again to 1.
Now again traverse through the array and find the count of majority element found.
If the count is greater than half the size of the array, print the element
Else print that there is no majority element

If the majority element was x and it by any chance appears on the left prefix then it count at max can be (lenOfLeftPrefix/2). So since it has to appear more than n/2 times, it is bound to appear as a majority in the last suffix.
For example- 7 7 5 7 5 1 | 5 7 | 5 5 7 7 | 5 5 5 5 
    */
    // public int majorityElement(int[] nums) {        
    //     Map<Integer,Integer> majorityElemMap = new HashMap<Integer,Integer>();
    //     int len = nums.length;
    //     int maxVal = 0, maxElem = nums[0];
    //     for(int i=0; i < len; i++){
    //         majorityElemMap.put(nums[i], 1 + (majorityElemMap.getOrDefault(nums[i],0)));
    //         if(majorityElemMap.get(nums[i]) > maxVal){
    //             maxVal = majorityElemMap.get(nums[i]);
    //             maxElem = nums[i];
    //         }
    //     }
    //     return maxElem;
    // }
    public int majorityElement(int[] nums){ // Boyer-Moore Voting Algorithm
        int count = 0;
        int candidate = 0;
        for(int n : nums){
            if(count == 0) candidate = n;
            if(n == candidate) ++count;
            else --count;
        }
        return candidate;
    }

}
