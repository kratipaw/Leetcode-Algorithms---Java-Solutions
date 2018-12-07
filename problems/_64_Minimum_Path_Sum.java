package problems;

/**
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
    which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
	
	Example:
	
	Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1→3→1→1→1 minimizes the sum.
	
 */

public class _64_Minimum_Path_Sum {

	public static void main(String[] args) {

		int[][] grid = {
		          	  	{1,3,1},
		          	  	{1,5,1},
		          	  	{4,2,1}
					   };
		
		System.out.println(new _64_Minimum_Path_Sum().minPathSum(grid));
	}

	// Runtime: 4 ms, faster than 98.55% of Java online submissions for Minimum Path Sum.
	public int minPathSum(int[][] grid) {
		
		if(grid == null || grid.length == 0)
			return -1;
		
		int rows = grid.length;
		
		int cols = grid[0].length;
		
		int[][] dp = new int[rows][cols];
		
		dp[0][0] = grid[0][0];
		
		for (int i = 1; i < rows ; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		
		for (int i = 1; i < cols; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		
		return dp[rows - 1][cols - 1];
    }
}
