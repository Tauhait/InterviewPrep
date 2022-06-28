Note that we can only decrement a number and cannot increment it. Hence, if we have two equal numbers, we will have to make one of these numbers smaller to make them unique. This is the key observation that we will use in the next three approaches.
​
how do we know that the number of characters we delete in the process is the minimum possible? The reason is for each frequency, we reduce it as few times as possible. When we have multiple occurrences of a frequency, we will reduce each frequency only until it becomes an unused frequency, and then we will stop. If the maximum frequency is xx, then all the frequencies have to be decremented (if needed) to be in the range [0, x][0,x].
​
Note that the processing order does not matter. For example, if we have the frequencies [4, 4, 5, 5], the final result will be [2, 3, 4, 5] or one of several other possible combinations of the frequencies 2, 3, 4, and 5 that can be obtained by decrementing the values in [4, 4, 5, 5]. And the cost will be (4 + 4 + 5 + 5) - (2 + 3 + 4 + 5) = 4 deletions. Since the number of deletions is just the difference in the sum of frequencies before and after making all frequencies unique, we would get the same result if our final frequencies were say [4, 2, 3, 5]. From this, we can conclude that the order in which we decrement frequencies, does not affect the number of deletions.
​
​
​
​