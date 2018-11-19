package problems;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

	The digits are stored such that the most significant digit is at the head of the list, and 
	each element in the array contain a single digit.
	
	You may assume the integer does not contain any leading zero, except the number 0 itself.
	
	Example 1:
	
	Input: [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.
	Example 2:
	
	Input: [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.
 */
public class _66_Plus_One {

	public static void main(String[] args) {

		int[] digits = {1, 2, 3};
		
		int[] res = new _66_Plus_One().plusOne(digits);
		
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
		System.out.println();
	}
	
	public int[] plusOne(int[] digits) {
        
        if(digits == null || digits.length == 0)
            return new int[0];
        
        int n = digits.length;
        
        int[] res = new int[n];
        
        int sum = 0;
        
        int carry = 0;
        
        int i = 0;
        
        for(i = n - 1; i>= 0; i--){
            
            if(i == n - 1)
                sum = digits[i] + 1;
            
            else
                sum = digits[i] + carry;
            
            if(sum >= 10)
                carry = 1;
            
            else
                carry = 0;
            
            sum = sum % 10;
            
            res[i] = sum;
        }
        
        if(carry > 0){
            int[] result = new int[n+1];
            System.arraycopy(res, 0, result, 1, n);
            result[0] = carry;
            return result;
        }
        
        return res;
    }

}
