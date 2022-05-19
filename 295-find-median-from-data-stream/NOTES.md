**Follow ups:**
**1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?**
​
We can maintain an integer array of length 100 to store the count of each number along with a total count. Then, we can iterate over the array to find the middle value to get our median.
​
Time and space complexity would be O(100) = O(1).
​
​
**2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?**
​
Since 99% of the elements fall between 0-100, skewness of the distribution will be mich high and we can apply the following Mathematical formula :
​
Median = ( Mode + 2 * Mean ) / 3