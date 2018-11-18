package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_BT_Level_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(root == null)
			return result;
		
		Queue<TreeNode> qu = new LinkedList<>();
		
		qu.add(root);
		
		while(!qu.isEmpty()) {
			
			int nodeCount = qu.size();

			if(nodeCount == 0)
				break;
			
			List<Integer> tmp = new ArrayList<Integer>();
			
			while(nodeCount > 0) {
				
				TreeNode node = qu.poll();
				tmp.add(node.val);
				
				if(node.left != null)
					qu.add(node.left);
				
				if(node.right != null)
					qu.add(node.right);
				
				nodeCount--;
			}
			result.add(tmp);
		}
		
		return result;
		
    }

}
