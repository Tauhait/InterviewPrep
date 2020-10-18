package faang;

public class ReverseLL1 {
	//  public ListNode reverseList(ListNode head) {
	//  if(head == null)
	//      return null;
	//  Stack<ListNode> nodeList  = new Stack<>();
	//  while(head.next != null){
	//      nodeList.push(head);
	//      ListNode temp = head.next;
	//      head.next = null;
	//      head = temp;
	//  }
	//  ListNode newHead = head;
	//  while(!nodeList.empty()){
	//      head.next = nodeList.pop();
	//      head = head.next;
	//  }
	//  head.next = null;
	 
	//  return newHead;        
	//}
	public ListNode reverseList(ListNode head){
		 if(head == null) return null;
		 ListNode dummyHead = null;
		 while(head != null){
		     ListNode next = head.next;
		     head.next = dummyHead;
		     dummyHead = head;
		     head = next;
		 }
		 return dummyHead;
	}
}
