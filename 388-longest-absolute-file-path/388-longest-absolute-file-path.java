class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);  // Layer 0, dummy head
        int maxLen = 0;
        for(String s : input.split("\n")) {
            int layer = s.lastIndexOf("\t") + 1;    // e.g. Layer 2 s: "\t\tsubsubdir1"
            while(layer < stack.size() - 1)
                stack.pop();
            int length = stack.peek() + s.length() - layer + 1; // remove "\t\t..." add "\"
            if(layer == 0)  // dir has no "\t" in the front
                length--;
            if(s.contains("."))
                maxLen = Math.max(maxLen, length);
            else
                stack.push(length);
        }
        return maxLen;
    }
}