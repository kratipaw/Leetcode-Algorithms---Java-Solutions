package problems;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	
    int label;
    
    RandomListNode next, random;
    
    RandomListNode(int x) {
    	this.label = x; 
    }
}

public class _138_Copy_List_With_Random_Pointer {

	public static void main(String[] args) {

		
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.random = head.next;
		
		head.next.next = new RandomListNode(3);
		head.next.random = head;
		
		//head.next.next.random = head;
		
		System.out.println("Original List : ");
		new _138_Copy_List_With_Random_Pointer().printLL(head);
		
		System.out.println("Via HashMap : ");
		new _138_Copy_List_With_Random_Pointer().copyRandomList_UsingHashmap(head);
		new _138_Copy_List_With_Random_Pointer().printLL(head);
		
		System.out.println("tricky : ");
		new _138_Copy_List_With_Random_Pointer().copyRandomList(head);
		new _138_Copy_List_With_Random_Pointer().printLL(head);
		
		
	}
	
	public void printLL(RandomListNode head) {
		
		RandomListNode node = head;
		
		while(node != null) {
			System.out.println("Node data : " + node.label + "   Random Data : " + ((node.random != null) ? node.random.label : "null"));
			
			node = node.next;
		}
	}

	//Using HashMap
	//Runtime: 4 ms, faster than 30.45% of Java online submissions for Copy List with Random Pointer.
	public RandomListNode copyRandomList_UsingHashmap(RandomListNode head) {
     
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode orig = head;
        
        RandomListNode curr = null;
        
        while(orig != null) {
        	
        	curr = new RandomListNode(orig.label);
        	
        	map.put(orig, curr);
        	
        	orig = orig.next;
        }
        
        orig = head;
        
        while(orig != null) {
        	
        	curr = map.get(orig);
        	
        	curr.next = map.get(orig.next);
        	
        	curr.random = map.get(orig.random);
        	
        	orig = orig.next;
        }
        
        RandomListNode result = map.get(head);
        
        return result;
    }
	
	//This solution gives Null Pointer Exception, but unable to detect why. The solution seems fine.
	public RandomListNode copyRandomList(RandomListNode head) {
	    
		if(head == null)
			return null;
		
        RandomListNode orig = head;
        
        RandomListNode curr = null;
        
        while(orig != null) {
        	
        	curr = new RandomListNode(orig.label);
        	
        	curr.next = orig.next;
        	
        	orig.next = curr;
        	
        	orig = curr.next;
        }
        
        orig = head;
        
        while(orig != null) {
        	
        	if(orig.random != null) 
        		orig.next.random = orig.random.next;
        	
        	else
        		
        		orig.next.random = null;
        	
        	orig = orig.next.next;
        }
        
        orig = head;
        
        RandomListNode newList = orig.next; 
        
        RandomListNode result = orig.next;
        
        while(orig != null) {
        	
        	orig.next = orig.next.next;
        	
        	if(newList.next != null)
        		newList.next = newList.next.next;
        	
        	else
        		newList.next = null;
        	
        	orig = orig.next;
        	
        	newList = newList.next;
        	
        }
        
        return result;
    }
}
