package problems;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.
	
	Example 1:
	
	Input: [1,3,5,6], 5
	Output: 2
	Example 2:
	
	Input: [1,3,5,6], 2
	Output: 1
	Example 3:
	
	Input: [1,3,5,6], 7
	Output: 4
	Example 4:
	
	Input: [1,3,5,6], 0
	Output: 0
	
 */

public class _35_Search_Insert_Position {

	public int searchInsert(int[] nums, int target) {
        
        int n = nums.length;
        
        if(n == 0)
            return 0;
        
        n = n - 1;
        
        int start = 0;
        
        while( start <= n){
            
            int mid = (start + n)/2;
            
            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid] < target)
                start = mid + 1;
            
            else
                n = mid - 1;
        }
        
        return start;
    }
}
