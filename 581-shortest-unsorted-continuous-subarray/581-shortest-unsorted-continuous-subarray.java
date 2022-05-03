class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> monoStack = new Stack<Integer>();
        int leftBoundary = nums.length, rightBoundary = 0;
        for(int i = 0; i < nums.length; i++){
            while(!monoStack.isEmpty() && nums[monoStack.peek()] > nums[i]){
                leftBoundary = Math.min(leftBoundary, monoStack.pop());
            }
            monoStack.push(i);
        }
        
        monoStack.clear();
        
        for(int i = nums.length - 1; i >= 0; i--){
            while(!monoStack.isEmpty() && nums[monoStack.peek()] < nums[i]){
                rightBoundary = Math.max(rightBoundary, monoStack.pop());
            }
            monoStack.push(i);
        }
        
        return rightBoundary - leftBoundary > 0 ? rightBoundary - leftBoundary + 1 : 0;
    }
}