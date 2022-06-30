Why did this work?
There is a thorough mathematic proof to this but I'll just try to explain this to you intuitively since you probably won't be able to spew out mathematical reasoning to this during an interview.
​
Let's first imagine we picked the smallest element as our target. What happens in this situation is we end up maximising the number of operations needed to get the largest element down to the target. If the largest number is really large or there are a lot of larger numbers, then this can end up totalling to a lot of operations.
If we instead picked the largest element as our target, the same thing happens but for smaller elements.
Therefore, intuitively, it's reasonable to suggest that if we picked the median element, we'll get the best of both worlds.
Approach 1: Sorting the array
​
This is fairly straight forward. If we simply sort the nums array, we can obtain the median by simply accessing the middle element. This allows us to find the median in O(nlogn) time. Keep in mind that if the array is of even length, we can just pick either of the two middle values as our median.
Approach 2: Quick Select
​
The sorting method is inefficient because it sorts the entire array. All we really need to do is put the median element where it's supposed to be; we don't care about where the other elements end up. Sound familiar? Well turns out we can do exactly that using quick select. In quick select, we'll just select the middle element; n/2 and retrieve the value at that position. This allows us to find the median element in O(n) time on average.
​
If you're unfamiliar with quick select, I highly recommend reading this guide that I wrote which explains the entire process in detail, including explanations for time complexity.
​
The thing about this question is that it's not necessarily easy to prove that the algorithm is going to work for every test case. This is especially true during an interview.
​
Interview tip: If you have a solution in mind but you're unclear whether or not the algorithm is always going to work, just show it working on a few distinct examples.
It's important to remember that your interviewer knows the strategies needed to solve the question quite well. Even if you don't know whether the solution is going to work, you could probably get that information from the interviewer. Just show your interview that the algorithm works for a couple distinct examples. If your interviewer seems happy with your approach, they'll display positive signals which should be a sign to you that it's okay to move forward with that strategy. On the other hand, if they're expressing scepticism, then assume that your solution is probably not what they're looking for.
​
Even once you've confirmed the strategy, you might run into another split on the road... what algorithms should you use to find the median? Chances are, you probably don't have quick select memorized. So, what should you do?
​
Interview tip: If there are multiple algorithms you could apply, pick the simplest one to implement and just mention the other approaches.
​
The truth of the matter is that it's better to have sub-optimal code that works than have a failed attempt at an optimal solution. What I recommend you do is just check with your interviewer whether it's alright to just implement the sorting algorithm in this case. However, bonus points if you can mention that the quick select strategy exists and that it would be a significant improvement to sorting. I suggest that you at least familiarise yourself with the quick select pseudocode and the pivot strategy so that you're at least able to explain it suffficiently.
​