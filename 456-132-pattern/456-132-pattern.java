class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3){
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();//mono stack to store sorted seqeunce for every j
        for(int j = nums.length - 1; j >= 0 ; j--){
            //we start from backwards to ensure the min[j] is the global minimum
            //implementation os mono stack 
            //stack.peek() refers to the kth index value
            while(!stack.isEmpty() && stack.peek() < nums[j]){// incr stack (top to bottom)
                //top element of stack is least
                if(stack.peek() > min[j]){
                    return true;
                }
                stack.pop();//ensures nums[j] is the smallest value at stack top
            }
            stack.push(nums[j]);
        }
        return false;
    }
}