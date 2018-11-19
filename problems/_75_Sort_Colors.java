package problems;

/**
 *  Given an array with n objects colored red, white or blue, sort them in-place so that 
 	objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue 
	respectively.
	
	Note: You are not suppose to use the library's sort function for this problem.
	
	Example:
	
	Input: [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	
	Follow up:
	
	- A rather straight forward solution is a two-pass algorithm using counting sort.
	- First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array 
		with total number of 0's, then 1's and followed by 2's.
	- Could you come up with a one-pass algorithm using only constant space?
	
 */
public class _75_Sort_Colors {

	public static void main(String[] args) {

		int[] nums = {2,0,2,1,1,0};
		
		new _75_Sort_Colors().sortColors(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "  ");
		}
		System.out.println();
	}
	
	public void sortColors(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return;
        
        int left = 0;
        
        int right = nums.length - 1;
        
        int mid = 0;
        
        int tmp = 0;
        
        while(mid <= right){
            
            int num = nums[mid];
            
            switch(num){
                    
                case 0:
                    tmp = nums[left];
                    nums[left] = num;
                    nums[mid] = tmp;
                    left++;
                    mid++;
                    break;
                    
                case 1:
                    mid++;
                    break;
                    
                case 2:
                    tmp = nums[right];
                    nums[right] = num;
                    nums[mid] = tmp;
                    right--;
                    break;
            }
        }
    }
}
