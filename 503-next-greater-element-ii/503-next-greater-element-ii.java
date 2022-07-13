class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> monoStk = new Stack<Integer>();
        int n = nums.length;
        int[] nge = new int[n];
        
        for(int i = 2*n-1; i >= 0; i--){
            while(!monoStk.isEmpty() && nums[i%n] >= nums[monoStk.peek()]) monoStk.pop();
            //keep on popping from the stack until 
            //the current element is less than stack top or 
            //stack is empty
            
            if(i < n) nge[i] = monoStk.isEmpty() ? -1 : nums[monoStk.peek()];
            monoStk.push(i%n);
        }
        return nge;
    }
}