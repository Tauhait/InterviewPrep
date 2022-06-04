The diagonals are a little trickier - but they have a property that we can use to our advantage.
​
For each square on a given diagonal, the difference between the row and column indices (row - col) will be constant. Think about the diagonal that starts from (0, 0) - the i^{th}i
th
square has the coordinates (i, i), so the difference is always 0.
![Pic](https://leetcode.com/problems/n-queens/Figures/51/diagonals.png)
For each square on a given anti-diagonal, the sum of the row and column indexes (row + col) will be constant. If you were to start at the highest square in an anti-diagonal and move downwards, the row index increments by 1 (row + 1), and the column index decrements by 1 (col - 1). These cancel each other out.
​
​
Complexity Analysis
​
Given NN as the number of queens (which is the same as the width and height of the board),
​
Time complexity: O(N!)O(N!)
​
Unlike the brute force approach, we will only place queens on squares that aren't under attack. For the first queen, we have NN options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N - 2N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N - 4N−4. This pattern continues, resulting in an approximate time complexity of N!N!.
​
While it costs O(N^2)O(N
2
) to build each valid solution, the amount of valid solutions S(N)S(N) does not grow nearly as fast as N!N!, so O(N! + S(N) * N^2) = O(N!)O(N!+S(N)∗N
2
)=O(N!)
​
Space complexity: O(N^2)O(N
2
)
​
Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens. However, to keep the board state costs O(N^2)O(N
2
), since the board is of size N * N. Space used for the output does not count towards space complexity.