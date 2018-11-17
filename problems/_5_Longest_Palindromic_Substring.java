package problems;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

	Example 1:
	
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	Example 2:
	
	Input: "cbbd"
	Output: "bb"
 */
public class _5_Longest_Palindromic_Substring {

	public String longestPalindrome(String s) {
        
        if(s == null || s.isEmpty() || s == "")
            return "";
        
        int n = s.trim().length();
        
        if(n == 0 || n == 1)
            return s;
        
        boolean dp[][] = new boolean[n][n];
        
        //Sub-strings of len 1 are palin
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        
        int start = 0;
        int maxLen = 1;
        
        //Sub-strings of len 2
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }
        
        //Sub-strings of len more than 2
        for(int len = 3; len <= n; len++){
            
            for(int i = 0; i < n - len + 1; i++){
                
                int j = i + len - 1;
                
                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                    
                    dp[i][j] = true;
                    
                    if(len > maxLen){
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        //System.out.println("start : " + start);
        //System.out.println("maxLen : " + maxLen);
        return s.substring(start, start + maxLen);
    }
}
