package faang;

public class MergeTwoSortedLinkedLists {
	public ListNode mergeTwoLists_OPT(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;		
		if(l1.val > l2.val) {
			ListNode copy = l1;
			l1 = l2;
			l2 = copy;
		}
		ListNode result = l1;
		while(l1 != null && l2 != null) {
			ListNode tmp = null;
			while(l1 != null && l1.val <= l2.val) {
				tmp = l1;
				l1 = l1.next;
			}
			tmp.next = l2;
			//swap
			ListNode copy = l1;
			l1 = l2;
			l2 = copy;			
		}
		return result;
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res;
        if(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res = new ListNode(l1.val);
                l1=l1.next;
            }else {
                res = new ListNode(l2.val);
                l2=l2.next;
            }
        }else if(l1 != null){
            res = new ListNode(l1.val);
            l1=l1.next;
        }else if(l2 != null){
            res = new ListNode(l2.val);
            l2=l2.next;
        }else return null;       
        ListNode head = res;
        
        while(l1 != null || l2 != null){  
            ListNode mergerList;
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    mergerList = new ListNode(l1.val);
                    l1=l1.next;                    
                }else {
                    mergerList = new ListNode(l2.val);
                    l2=l2.next;
                }
            }else if(l1 != null){
                mergerList = new ListNode(l1.val);
                l1=l1.next;
            }else {
                mergerList = new ListNode(l2.val);
                l2=l2.next;
            }
            res.next=mergerList;
            res=res.next;            
            
        }
        return head;
    }
    
}
