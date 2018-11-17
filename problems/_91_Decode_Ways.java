package problems;

public class _91_Decode_Ways {

	public static void main(String[] args) {

		String s = "12";
		
		System.out.println(new _91_Decode_Ways().numDecodings(s));
		
	}

	public int numDecodings(String s) {
        
		char digits[] = s.toCharArray();
		
		int n = digits.length;
		
		if(n == 0 || digits[0] == '0')
			return 0;
        
		//count[i] stores the number of valid decodings we can get from 0...i digits
		int count[] = new int[n+1];
		
		count[0] = 1;
		count[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			
			if(digits[i-1] > '0' && digits[i-1] <= '9')
				count[i] = count[i-1];
			
			if(digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] < '7'))
				count[i] = count[i] + count[i-2];
			
		}
		
		return count[n];
    }
}
