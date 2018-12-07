package problems;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

	For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
	
	Example:
	
	Given the sorted linked list: [-10,-3,0,5,9],
	
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 */

public class _109_Convert_Sorted_List_to_BST {

	static ListNode h;
    
    public TreeNode sortedListToBST(ListNode head) {
        
        int n = countNodes(head);    
        
        h = head;
        System.out.println("n : " + n);
        return sortedListToBSTRecur(n);
    }
    
    public int countNodes(ListNode head){
        
        ListNode node = head;
        
        if(node == null)
            return 0;
        
        int len = 0;
        
        while(node != null){
            len++;
            node = node.next;
        }
        
        return len;
    }
    
    public TreeNode sortedListToBSTRecur(int n){
        
        if(n <= 0)
            return null;
        
        TreeNode left = sortedListToBSTRecur(n/2);
        
        TreeNode root = new TreeNode(h.val);
        
        root.left = left;
        
        h = h.next;
       
        root.right = sortedListToBSTRecur(n - n/2 - 1);
        
        return root;
    }
    

}
