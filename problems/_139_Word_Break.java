package problems;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	Note:
	
	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:
	
	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	Example 2:
	
	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.
	Example 3:
	
	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false

 */

public class _139_Word_Break {

	public static void main(String[] args) {
		
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
		
		if(n == 0)
			return true;
		
		boolean dp[] = new boolean[n + 1];
		
		dp[0] = true; //Here dp[i] is true if 's' can be broken into parts 0-i-1 and both the sub-strings present in dict 
		
		for (int i = 0; i < n; i++) {
			
			if(!dp[i])
				continue;
			
			for(String word : wordDict) {
				
				int len = word.length();
				
				int end = i + len;
				
				if(end > n)
					continue;
				
				if(dp[end])
					continue;
				
				if(s.substring(i, end).equals(word))
					dp[end] = true;
			}
		}
		
		return dp[n];
    }

}
