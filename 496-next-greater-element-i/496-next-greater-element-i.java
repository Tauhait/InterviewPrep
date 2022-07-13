class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums1.length; i++) numMap.put(nums1[i], i);
        
        Stack<Integer> monoStk = new Stack<Integer>();//keeps the next greater element

        for(int i = nums2.length-1; i >= 0; i--){
            while(!monoStk.isEmpty() && nums2[i] > nums2[monoStk.peek()]) monoStk.pop();
            
            if(numMap.containsKey(nums2[i])) {
                int index = numMap.get(nums2[i]);
                if(!monoStk.isEmpty()) ans[index] = nums2[monoStk.peek()];
                else ans[index] = -1;
            }
            monoStk.push(i);
        }
        return ans;
    }
}