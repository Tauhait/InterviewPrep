Algo:
1. Pivot element is larger than the first element in the array, i.e. the subarray from the first element to the pivot is non-rotated
- If the target is located in the non-rotated subarray:
go left: `end = mid - 1`.
​
- Otherwise: go right: `start = mid + 1`.
​
2. Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. It implies that the sub-array from the pivot element to the last one is non-rotated, as shown in the following graph.
- If the target is located in the non-rotated subarray:
go right: `start = mid + 1`.
​
- Otherwise: go left: `end = mid - 1`.