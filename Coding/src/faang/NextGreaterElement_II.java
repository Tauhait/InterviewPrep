package faang;

import java.util.Stack;

public class NextGreaterElement_II {
	//Brute force approach: TC - O(n*n) SC - O(1)S
	public int[] nextGreaterElements_brute(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = -1;
        for(int i = 0; i < n; i++){
            for(int j = (i + 1 == n ? 0 : i + 1); j != i; j = (j + 1) % n) {
                if(nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
	//Optimal approach using Stack: TC - O(n) SC - O(1)
	public int[] nextGreaterElements_opt(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> nxtGrtElemStk = new Stack<Integer>();
        for(int pass = 1; pass <= 2; pass++){
            for(int i = n - 1; i >= 0; i--){
                while(!nxtGrtElemStk.empty() && nums[i] >= nums[nxtGrtElemStk.peek()]) nxtGrtElemStk.pop();
                ans[i] = !nxtGrtElemStk.empty() ? nums[nxtGrtElemStk.peek()] : -1;
                nxtGrtElemStk.push(i);
            }
        }        
        return ans;
    }
}
