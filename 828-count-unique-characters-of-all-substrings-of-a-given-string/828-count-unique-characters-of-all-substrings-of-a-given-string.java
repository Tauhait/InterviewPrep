class Solution {
    public int uniqueLetterString(String s) {
        int[] lastPosition = new int[26];
        int[] contribution = new int[26];
        int res = 0;

    //  Basically, at each iteration,
    //  we count the contribution of all the characters to all the substrings ending till that point.

        for (int i = 0; i < s.length(); i++) {

          int curChar = s.charAt(i) - 'A';

    //    Now, we need to update the contribution of curChar.
    //    The total number of substrings ending at i are i+1. 
    //    So if it was a unique character, it'd contribute to all of those
    //    and it's contribution would have been i+1.
    //    But if it's repeating, it means it has already contributed previously. So remove it's previous contribution.
    //    We can do that as we have it's last position.
    //    So these are the contributions for strings which start after this character's last occurrence and end at i.
    //    A simple example will demonstrate that the number of these strings are i+1 - lastPosition[curChar]
    //    For characters not appeared till now, lastPosition[curChar] would be 0.
          int totalNumOfSubstringsEndingHere = i + 1;
          contribution[curChar] = totalNumOfSubstringsEndingHere - lastPosition[curChar];

    //    Note that, the contribution of all the other characters will remain same.

    //    count the cur answer by summing all the contributions. 
    //    This loop can be avoided by the idea in original post, but I find
    //    it easy to understand with this and it only iterates over 26 values.
          int cur = 0;
          for (int j = 0; j < 26; j++) cur += contribution[j];


    //    add the current value to final answer.
          res += cur;

    //    update the last position of this char. This helps in future to count it's contribution if it appears again.
          lastPosition[curChar] = i + 1;
        }
        return res;
    }
}