package problems;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	Example:
	
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 */
public class _1_TwoSum {

	public static void main(String[] args) {

		int[] nums = {2, 7, 11, 15};
		
		int target = 9;
		
		int result[] = new _1_TwoSum().twoSum(nums, target);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        
        int[] result = null;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            int tmp = target - nums[i];
            
            if(map.containsKey(tmp)){
                result = new int[]{map.get(tmp), i};
                return result;
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
}
