```
while (tail2 >= 0) { //only need to combine with remaining nums2
nums1[finished--] = nums2[tail2--];
}
​
```
The above code is useful when:
​
This is useful if there are leftover values not used from num2, such as if num1 is 4 5 6 0 0 0 and num2 is 1 2 3. The first loop would go through 4 5 6 4 5 6, then reach tail1=-1 and exit. This isn't necessary for nums1 because the array starts with any beginning values in the correct positions.