class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int j = nums.length - 1; j >= 0 ; j--){
            while(!stack.isEmpty() && stack.peek() < nums[j]){// incr stack (top to bottom)
                //top element of stack is least
                if(stack.peek() > min[j]){
                    return true;
                }
                stack.pop();
            }
            stack.push(nums[j]);
        }
        return false;
    }
}