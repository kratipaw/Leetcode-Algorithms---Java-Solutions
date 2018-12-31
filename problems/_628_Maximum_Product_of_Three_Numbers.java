package problems;

import java.util.Arrays;

/**
 * 
	Given an integer array, find three numbers whose product is maximum and output 
	the maximum product.

	Example 1:
	Input: [1,2,3]
	Output: 6
	
	Example 2:
	Input: [1,2,3,4]
	Output: 24
	
	Note:
	- The length of the given array will be in range [3,104] and all elements are 
		in the range [-1000, 1000].
	- Multiplication of any three numbers in the input won't exceed the range of 
		32-bit signed integer.
 
 */
public class _628_Maximum_Product_of_Three_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Runtime: 30 ms, faster than 17.32% of Java online submissions
	//TC = O(nLogn), SC = O(1)
	public int maximumProduct(int[] nums) {
	     
        int n = nums.length;
        
        Arrays.sort(nums);
        
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
	
	//Runtime: 11 ms, faster than 65.30% of Java online submissions
	//TC = O(n), SC = O(1)
	public int maximumProduct_better(int[] nums) {
	    
		int maxOne = Integer.MIN_VALUE;
		int maxTwo = Integer.MIN_VALUE;
		int maxThree = Integer.MIN_VALUE;
		
		int minOne = Integer.MAX_VALUE;
		int minTwo = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			
			if(nums[i] > maxOne) {
				maxThree = maxTwo;
				maxTwo = maxOne;
				maxOne = nums[i];
			}
			
			else if(nums[i] > maxTwo) {
				maxThree = maxTwo;
				maxTwo = nums[i];
			}
			
			else if(nums[i] > maxThree){
				maxThree = nums[i];
			}
			
			if(nums[i] < minOne) {
				minTwo = minOne;
				minOne = nums[i];
			}
			
			else if(nums[i] < minTwo) {
				minTwo = nums[i];
			}
		}
		
		return Math.max(maxThree * maxTwo * maxOne, minOne * minTwo * maxOne);
    }
	

}
