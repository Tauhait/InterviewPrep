The previous implements all have no assumption on the charset of the string s.
​
If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
​
Commonly used tables are:
​
int[26] for Letters 'a' - 'z' or 'A' - 'Z'
int[128] for ASCII
int[256] for Extended ASCII
​