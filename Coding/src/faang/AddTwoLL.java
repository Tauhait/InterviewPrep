package faang;

import java.util.Stack;

public class AddTwoLL {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        Stack<Integer> result = new Stack<Integer>();
        while(l1 != null) { stk1.push(l1.val); l1 = l1.next; }
        while(l2 != null) { stk2.push(l2.val); l2 = l2.next; }
        int carry = 0;
        while(!stk1.empty() && !stk2.empty()) {
            int a = stk1.pop();
            int b = stk2.pop();
            int sum = a + b + carry;
            if(sum >= 10) { 
                sum -= 10;
                carry = 1;
            }else carry = 0;
            result.push(sum);            
        }
        while(!stk1.empty()) { 
            int sum = stk1.pop() + carry;
            if(sum >= 10) { 
                sum -= 10;
                carry = 1;
            }else carry = 0;
            result.push(sum);
        }
        while(!stk2.empty()) { 
            int sum = stk2.pop() + carry;
            if(sum >= 10) { 
                sum -= 10;
                carry = 1;
            }else carry = 0;
            result.push(sum);
        }        
        if(carry > 0) result.push(carry);
        
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        makeResultLL(result, dummy);
        return dummy.next;   
    }
    private void makeResultLL(Stack<Integer> result, ListNode dummy) {
        while(!result.empty()) {
            ListNode newNode = new ListNode();
            newNode.val = result.pop();
            dummy.next = newNode;
            dummy = newNode;
        }
    }
    public ListNode addTwoNumbers_OPT(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}
