class Solution {
    // https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> indexDeque = new ArrayDeque<>();// store indexes of elements in dcr order
        for(int i = 0; i < nums.length; i++){
            //before processing current nums[i] check if window in deque is valid
            if(!indexDeque.isEmpty() && indexDeque.getFirst() == i - k) 
                indexDeque.removeFirst();

            // remove from end in deque indexes where current nums[i] > elements
            while(!indexDeque.isEmpty() && nums[indexDeque.getLast()] <= nums[i]) 
                indexDeque.removeLast();

            indexDeque.addLast(i);

            if(i >= k - 1) 
                ans[index++] = nums[indexDeque.peekFirst()];// first element will be the largest as we store in dcr order inside deque
        }
        return ans;
    }
}