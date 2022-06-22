Use a partition algorithm to place the pivot into its perfect position pos in the sorted array, move smaller elements to the left of pivot, and larger or equal ones - to the right.
If our pivot comes before the "kth largest" index, perform quickselect on the right partition.
If our pivot comes after the "kth largest" index, perform quickselect on the left partition.
Performing quickselect only on one partition reduces our average-case complexity from O(nlogn) to O(n).
​
Note: quickselect (and quicksort) have a worst-case of O(n^2). This would occur whenever a pivot we choose is an extreme; the smallest or largest element.
In practice, however, quickselect and quicksort are incredibly fast algorithms and the worst-case occurrence is quite unnoticeable on large sets of data.
​
That's basically it regarding how it works!
​
Our algorithm is quite simple:
​
function quickSelect(nums, left, right, k)
if left = right return nums[left]   // base case
​
pIndex = random element between left and right
pIndex = partition(nums, left, right, pIndex)
if k = pIndex
return nums[k]
else if k < pIndex
return quickselect with: right = pIndex - 1
else
return quickselect with: left = pIndex + 1
Keep in mind that k above represents the kth smallest element; not the largest. We handle this in our main function as aforementioned.
All we need now are a couple of helper functions, namely partition() and swap().
​
As you can see, after partitioning, our pivot is at the exact index it's supposed to be in a sorted array. Not only that but all the elements less than 4 are to the left of it and all the elements to the right are greater than it. Awesome! This is our expected behaviour.
​