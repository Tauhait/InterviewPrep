package faang;

public class CovertSortedListToBST {
	   /* Idea 1: Recursive soln TC - O(n lg n) SC - O(lg n)
    The main idea in this approach and the next is that:
the middle element of the given list would form the root of the binary search tree. 
All the elements to the left of the middle element would form the left subtree recursively. 
Similarly, all the elements to the right of the middle element will form the right subtree of the binary search tree. 
This would ensure the height balance required in the resulting binary search tree
    */
	
	/* Idea 2: TC - O(n) SC - O(n)
    Time Complexity: The time complexity comes down to just O(N) now since we convert the linked list to an array initially and 
    then we convert the array into a BST. Accessing the middle element now takes O(1) time and hence the time complexity comes down.
    
Space Complexity: Since we used extra space to bring down the time complexity, the space complexity now goes up to O(N) as opposed to just O(logN) in the previous solution.
This is due to the array we construct initially.
    */
	
	/*  Idea 3: TC - O(n) SC - O(lg n)
	 The critical idea based on the inorder traversal that we will exploit to solve this problem, is:
We know that the leftmost element in the inorder traversal has to be the head of our given linked list. 
Similarly, the next element in the inorder traversal will be the second element in the linked list and so on. 
This is made possible because the initial list given to us is sorted in ascending order.
	 
	 */
	public TreeNode sortedListToBST(ListNode head) {
        if(null == head) return null; 
        if(null == head.next) return new TreeNode(head.val);        
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(null != fast && null != fast.next){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }        
        prev.next = null;
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}
