Let n = numn=num.
​
Time Complexity : O(\log \, n)O(logn).
​
Converting a number into string can be done in \log \, nlogn time.
​
We then loop over each bit, doing a single operation each time. The number of bits in a number is \log_2 \, numberlog
2
•
number, so the time complexity is O(\log \, n)O(logn).
​
Space Complexity : O(\log \, n)O(logn).
​
Because we convert the number into a string, we'll have \log_2 \, numberlog
2
•
number characters in our string. This gives us a space complexity of O(\log \, n)O(logn).
​
​