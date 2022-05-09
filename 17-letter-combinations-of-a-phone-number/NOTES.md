the hard part is just figuring out how to correctly generate all possible combinations, and to do this using a standard backtracking algorithm template. Let's break down the problem, by starting with an input that is only 1-digit long, for example digits = "2". This example is trivial - just generate all letters that correspond with digit = "2", which would be ["a", "b", "c"].
​
What if instead we had a 2-digit long input, digits = "23"? Imagine taking each letter of digit = "2" as a starting point. That is, lock the first letter in, and solve all the possible combinations that start with that letter. If our first letter will always be "a", then the problem is trivial again - it's the 1-digit case, and all we have to do is generate all the letters corresponding with digit = "3", and add that to "a", to get ["ad", "ae","af"]. This was easy because we ignored the first letter, and said it will always be "a". But we know how to generate all the first letters too - it's the 1-digit case which we already solved to be ["a", "b", "c"].
​
As you can see, solving the 1-digit case is trivial, and solving the 2-digit case is just solving the 1-digit case twice. The same reasoning can be extended to n digits. For the 3-digit case, solve the 2-digit case to generate all combinations of the first 2 letters, and then solve the 1-digit case for the final digit. Now that we know how to solve the 3-digit case, to solve the 4-digit case, solve the 3-digit case for all combinations of the first 3 letters, and then solve the 1-digit case for the final digit. We could extend this to infinity, but, don't worry, for this problem we're finished after 4.
​
Complexity Analysis
​
Time complexity: O(4^N \cdot N)O(4
N
⋅N), where NN is the length of digits. Note that 44 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
​
The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra digit. Then, for each combination, it costs up to NN to build the combination. This problem can be generalized to a scenario where numbers correspond with up to MM digits, in which case the time complexity would be O(M^N \cdot N)O(M
N
⋅N). For the problem constraints, we're given, M = 4M=4, because of digits 7 and 9 having 4 letters each.
​
Space complexity: O(N)O(N), where NN is the length of digits.
​
Not counting space used for the output, the extra space we use relative to input size is the space occupied by the recursion call stack. It will only go as deep as the number of digits in the input since whenever we reach that depth, we backtrack.
​
As the hash map does not grow as the inputs grows, it occupies O(1)O(1) space.
​
​
This problem is not 'strictly' backtracking in the sense of it. But the re use of the same array and adding and removing from the array around the recursive calls is the same principle on which most backtracking problems and algorithms depend.
​
Problem needs to generate all possible combinations but if we use backtracking method then we save on space complexity whereas in brute force it will be O(n^4) in the worst case.