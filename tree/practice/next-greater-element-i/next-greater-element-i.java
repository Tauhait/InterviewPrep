class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> numNextGreaterMap = new HashMap<>();
        for(int n : nums2){
            while(!stack.isEmpty() && stack.peek() < n){
                numNextGreaterMap.put(stack.pop(), n);
            }
            stack.push(n);
        }
        while(!stack.isEmpty()){
            numNextGreaterMap.put(stack.pop(), -1);
        }
        for(int i = 0; i < nums1.length; i++){
            ans[i] = numNextGreaterMap.get(nums1[i]);
        }
        return ans;
    }
}