package faang;

import java.util.Stack;

public class RemoveDuplicates {
	public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> cStk = new Stack<Character>();
        cStk.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cStk.empty() && c == cStk.peek()){
                cStk.pop();
            }else {
                cStk.push(c);
            }
        }
        while(!cStk.empty()){
            sb.insert(0, cStk.pop());
        }
        return sb.toString();
    }
	/* Two Pointer Approach
	 public String removeDuplicates(String S) {
        char[] a = S.toCharArray();
        int end = -1;
        for (char c : a) {
            if (end >= 0 && a[end] == c) { 
                --end; 
            }else { 
                a[++end] = c; 
            }
        }
        return String.valueOf(a, 0, end + 1);
    }
    
    Follow Up - 
    What if we are required to remove all k-in-a-row duplicates in a string (for more-than-k-in-a-row, remove only first k duplicates)?
    Use 2 stacks, one for characters, and the other for the count of adjacent characters.

    public String removeDuplicates(String S, int k) {
        Deque<Character> charStk = new ArrayDeque<>();
        Deque<Integer> cntStk = new ArrayDeque<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (charStk.isEmpty() || charStk.peek() != c) { // no char in stack yet, or top char is different from the current.
                charStk.push(c);
                cntStk.push(1);
            }else if (cntStk.peek() + 1 < k) { // top char is same as the current, but less than k after appending the current.
                cntStk.push(cntStk.pop() + 1);
            }else { // found k-in-a-row duplicates, remove them.
                charStk.pop();
                cntStk.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charStk) {
            int cnt = cntStk.pop();
            while (cnt-- > 0) {
                sb.append(c);
            }
        }
        return sb.reverse().toString(); // Do NOT forget reverse().
    }
    
    */
}
