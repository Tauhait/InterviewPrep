class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        
        Arrays.fill(prev , -1);
        Arrays.fill(next , n);
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if(!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }        
        st.clear();
        
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            if(!st.isEmpty()) next[i] = st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = 0; i < n; i++){
            long leftMin = i-prev[i];
            long rightMin = next[i]-i;
            sum -= leftMin*rightMin*nums[i];
        }
        
        Arrays.fill(prev , -1);
        Arrays.fill(next , n);
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }
        st.clear();
        
        for(int i = n-1 ; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();            
            if(!st.isEmpty()) next[i] = st.peek();            
            st.push(i);
        }
        
        
        for(int i = 0; i < n; i++){
            long leftMax = i-prev[i];
            long rightMax = next[i]-i;
            sum += leftMax*rightMax*nums[i];
        }
        
        return sum;
    }
}