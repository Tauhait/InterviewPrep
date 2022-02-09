class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        LinkedList<Integer> stk = new LinkedList<Integer>();
        for(int i = len - 1; i >= 0; i--){            
            while(!stk.isEmpty() && T[i] >= T[stk.peek()]) stk.pop();                
            res[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }        
        return res;
    }
}