The reason is that in 1st solution,
​
```String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);```
takes O(n) time since the postorder() returns a string
​
while in the 2nd solution,
​
```String curSerial = leftId + "," + root.val + "," + rightId;```
takes O(1) constant time since both leftId and rightId is an integer.