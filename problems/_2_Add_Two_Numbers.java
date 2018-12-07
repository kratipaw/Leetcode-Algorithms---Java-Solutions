package problems;

/**
    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
	
	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example:
	
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
 */
public class _2_Add_Two_Numbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		new _2_Add_Two_Numbers().printLinkedList(l1);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		new _2_Add_Two_Numbers().printLinkedList(l2);
		
		ListNode result = new _2_Add_Two_Numbers().addTwoNumbers_slow(l1, l2);
		
		new _2_Add_Two_Numbers().printLinkedList(result);
		
	}
	
	private void printLinkedList(ListNode node) {
    	
		ListNode element = node;
    	
    	while(element != null) {
    		System.out.print(element.val + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
	
	// Runtime of 54ms
	public ListNode addTwoNumbers_slow(ListNode l1, ListNode l2) {
        
		ListNode result = null;
		
		ListNode prev = null;
		
		ListNode tmp = null;
		
        int sum = 0;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
        
        	int dt1 = 0;
        	if(l1 != null)
        		dt1 = l1.val;
        	

        	int dt2 = 0;
        	if(l2 != null)
        		dt2 = l2.val;
        	
        	sum = dt1 + dt2 + carry;
        	
        	if(sum >= 10)
        		carry = 1;
        	
        	else
        		carry = 0;
        	
        	sum = sum % 10;
        	
        	tmp = new ListNode(sum);
        	
        	if(result == null)
        		result = tmp;
        	
        	else
        		prev.next = tmp;
        	
        	prev = tmp;
        	
        	if(l1 != null)
        		l1 = l1.next;

        	if(l2 != null)
        		l2 = l2.next;
        }
        
        if(carry > 0)
        	tmp.next = new ListNode(carry);
        
        return result;
        
    }
	
	// Runtime: 27 ms, faster than 73.10% of Java online submissions for Add Two Numbers.
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0);
			
			ListNode curr = dummy;
	        
			ListNode A = l1;
			
			ListNode B = l2;
			
	        
	        int sum = 0;
	        
	        int carry = 0;
	        
	        while(A != null || B != null) {
	        
	        	int dt1 = 0;
	        	if(A != null)
	        		dt1 = A.val;
	        	

	        	int dt2 = 0;
	        	if(B != null)
	        		dt2 = B.val;
	        	
	        	sum = dt1 + dt2 + carry;
	        	
	        	if(sum >= 10)
	        		carry = 1;
	        	
	        	else
	        		carry = 0;
	        	
	        	sum = sum % 10;
	        	
	        	curr.next = new ListNode(sum);
	        	curr = curr.next;
	        	
	        	if(A != null)
	        		A = A.next;

	        	if(B != null)
	        		B = B.next;
	        }
	        
	        if(carry > 0)
	        	curr.next = new ListNode(carry);
	        
	        return dummy.next;
	    }

}
