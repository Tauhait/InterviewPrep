This is a very popular interview question. A concern I've seen brought up on the forums is that this question is too big to do in an interview.
​
Keep in mind though, that you're being compared to other candidates. They too will struggle with this, unless they've seen it before and memorized it. This however will be obvious to an experienced interviewer. It is the candidate who has clearly never seen it before yet makes great progress (probably not writing a complete implementation) who will be considered the most impressive. The secret would be to prioritize your time so that you are focusing on the core of the problem and not implementations of straightforward helper methods.
​
For this question, great progress would probably be deriving the intuition discussed in approach 2 and then writing code for the core algorithm of Approach 2 or Approach 3.
​
Remember that you don't necessarily have to "implement" every helper method. For example, some implementations rely on checking if a part of a string is a palindrome. This detail is easy-level by Leetcode standards, and in particular if you're using a whiteboard, it's a waste of time and space to write it unless you have finished the core algorithm. Simply state how you'd do it and leave it as a method signature unless asked to do otherwise. Also (for Approach 3), keep the TrieNode class simple. Don't waste half the whiteboard writing getters and setters for it.
​
​
Approach 1: Brute force
Intuition
​
The brute force solution is a good place to start. For this question, it is straightforward. Iterate over every possible pair of strings and check whether or not they form a palindrome.
​
You probably won't be writing this code, there simply won't be time. But make sure you know what it would be, and that you could describe the algorithm line-by-line if needed.
​
Algorithm
​
We can do this using 2 nested loops, each loop going over each index in the array. For each pair we need to check whether or not it forms a palindrome. There are many ways of doing this step, here I recommend the simplest way: creating the combined word and the reversed combined word and checking if they're equal. Doing the check in a more efficient way at this stage is not worth it — we want to focus our efforts on optimizing the main inefficiencies in this algorithm, which are discussed further in the complexity analysis section.
​
An important edge case to be careful of is where i = j. The problem states that i and j must be distinct (in other words, not the same). Identifying this edge case now is important, because we'll also need to be careful of it when we are optimizing our algorithm.
​
​
1.Check if the reverse of word is present. If it is, then we have a case 1 pair by appending the reverse onto the end of word.
2.For each suffix of word, check if the suffix is a palindrome. if it is a palindrome, then reverse the remaining prefix and check if it's in the list. If it is, then this is an example of case 2.
3.For each prefix of word, check if the prefix is a palindrome. if it is a palindrome, then reverse the remaining suffix and check if it's in the list. If it is, then this is an example of case 3.
​
​
​
***
Case 2 with the Trie
​
Case 2 is the one where the first word is shorter than the second word. The second word starts with a palindrome, and ends with the reverse of the first word. So, how will this look in our Trie?
​
Well, let's just have a look. The example we'll work with this time is "TAC". Like before, we know that the last 3 letters of the second word must start with "CAT". Now, remembering that these would have been inserted in reverse, we will start by looking for "TAC". Once we have found those letters, we would expect to not yet be at the end of a word, but for there to be a word that only has a palindrome left.
​
​
​