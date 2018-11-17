package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets {

	public static void main(String[] args) {

		int nums[] = {1, 2, 3};
		
		List<List<Integer>> result = new _78_Subsets().subsets(nums);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).toString());
		}
	}
	
	public List<List<Integer>> subsets(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(nums == null || nums.length == 0)
			return result;
		
		Arrays.sort(nums);
		
		List<Integer> subset = new ArrayList<Integer>();
		
		result.add(subset);		
		
		subsetsUtil(nums, result, subset, 0);
        
		return result;
		
    }
	
	public void subsetsUtil(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
		
		for (int i = start; i < nums.length; i++) {
			
			subset.add(nums[i]);
			
			List<Integer> tmp = new ArrayList<>(subset);
			
			result.add(tmp);
			
			//recur
			subsetsUtil(nums, result, subset, i + 1);
			
			//backtrack
			subset.remove(subset.size() - 1);
		}
		
	}

}
