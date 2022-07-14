Stable Sort
​
One might notice that in the above implementation one can find the logic that corresponds each of the rules, except the Rule (3).
​
Indeed, we did not do anything explicitly to ensure the order imposed by the Rule (3).
​
The short answer is that the Rule (3) is ensured implicitly by an important property of sorting algorithms, called stability.
​
It is stated as "stable sorting algorithms sort equal elements in the same order that they appear in the input."
​
Not all sort algorithms are stable, e.g. merge sort is stable.
​
The Arrays.sort() interface that we used is stable, as one can find in the specification.
​
Therefore, the Rule (3) is implicitly respected thanks to the stability of the sorting algorithm that we used.
​
Complexity Analysis
​
Let NN be the number of logs in the list and MM be the maximum length of a single log.
​
Time Complexity: \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN)
​
First of all, the time complexity of the Arrays.sort() is \mathcal{O}(N \cdot \log N)O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked \mathcal{O}(N \cdot \log N)O(N⋅logN) times.
​
For each invocation of the compare() function, it could take up to \mathcal{O}(M)O(M) time, since we compare the contents of the logs.
​
Therefore, the overall time complexity of the algorithm is \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN).
​
Space Complexity: \mathcal{O}(M \cdot \log N)O(M⋅logN)
​
For each invocation of the compare() function, we would need up to \mathcal{O}(M)O(M) space to hold the parsed logs.
​
In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is \mathcal{O}(\log n)O(logn), assuming that the space for each element is \mathcal{O}(1)O(1)). Since each log could be of \mathcal{O}(M)O(M) space, we would need \mathcal{O}(M \cdot \log N)O(M⋅logN) space to hold the intermediate values for sorting.
​
In total, the overall space complexity of the algorithm is \mathcal{O}(M + M \cdot \log N) = \mathcal{O}(M \cdot \log N)O(M+M⋅logN)=O(M⋅logN).
​
​