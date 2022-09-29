Both the Java and Python implementations require O(k)O(k) time to build the result. However, it is worth noting that if the input array were given as a list instead of an array of integers, then the Java implementation could use the ArrayList.subList() method to build the result in O(1)O(1) time. If this were the case, the Java solution would have an (extremely fast) overall time complexity of O(\log(N - k))O(log(N−k)).
​
EDIT: I actually likes @ataraxiatic intuitive explanation better. Go read it: https://leetcode.com/problems/find-k-closest-elements/solution/1400540
​
The corner case that breaks abs(x - arr[mid]) > abs(arr[mid + k] - x) is when arr[mid] to arr[mid + k] are all the same and the numbers are smaller than x (if they're larger it's no problem). For example,
​
[1,1,2,2,2,2,2,3,3]
3
3
In the first iteration, mid equals to 3 and arr[3] to arr[3 + 3] is [2,2,2,2]. Because abs(x - arr[mid]) == abs(arr[mid + k] - x), we will recursive into the left half, which is wrong.
​
Now let's see how x - arr[mid] > arr[mid + k] - x works:
There are 3 possible positions x can be relative to arr[mid] and arr[mid + k]. Say this array is sorted from small to large, : [x1, arr[mid], x2, arr[mid + k], x3]
​
Case x1:
x1 is smaller than both arr[mid] and arr[mid + k]. We should recurse into the left.
x - arr[mid] is negative and arr[mid + k] - x is positive.
The condition is false and we recurse to left. With abs(), we also recurse to left.
​
Case x2:
x2 is in between arr[mid] and arr[mid + k]. We should recurse to the side that is closer to x.
x - arr[mid] and arr[mid + k] - x are both positive.
The comparison works the same as using abs(); we recursive to the closer side.
(When in the case of arr[mid] == arr[mid + k], the condition is false and we recurse to the left.)
​
Case x3:
x3 is larger than both arr[mid] and arr[mid + k]. We should recurse into the right.
x - arr[mid] is positive and arr[mid + k] - x is negative.
The condition is true and we recurse to right.
Now the previously failed corner case arr[mid] == arr[mid + k] < x3 doesn't cause a problem anymore because the sign of the numbers we're comparing is still the same.
​