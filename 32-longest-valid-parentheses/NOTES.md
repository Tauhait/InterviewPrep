We define the subproblem as dp(idx) := length of the longest valid parentheses which use s[idx] as end.
​
We only compute when s[idx] == ')' since '(' can't be the end of a valid parentheses.
​
The recurrence relationship is:
​
when s[idx - 1] == '(':
'(' and ')' at idx - 1 and idx respectively already form a valid (), since we want to form the longest substring, we want to check if the substring end with s[idx - 2] is also valid, if valid, we need to add the length of it (dp(idx - 2)).
dp(idx) = 2 + dp(idx - 2)
when s[idx - 1] == ')':
first we need to check if substring end at idx - 1 is valid, if not. then we can't use idx as end neither. if valid, we want to make sure that ) at idx has a '(' to match it, without this '(', substring end at idx can't be valid as well. So what's the position should such '(' located? Its position is at idx - dp(idx - 1) - 1, e.g. ....( (()) ), previous valid parentheses length is 4, so the '(' matching ')' at idx is at idx - 4 - 1, where 4 = dp(idx - 1). as in case 1, we want to check if the substring can be longer, so we check the previous index which is left to the '(' that match ')' at idx. Its index is idx - dp(idx - 1) - 2.
if dp(idx - 1) > 0 && s[idx - dp(idx - 1) - 1] == '(': dp(idx) = 2 + dp(idx - 1) + dp(idx - dp(idx - 1) - 2)
Base case is trivial, dp(idx) = 0 if idx <= 0