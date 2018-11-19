package problems;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate 
   (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and 
   (i, 0). Find two lines, which together with x-axis forms a container, such that 
   the container contains the most water.

	Note: You may not slant the container and n is at least 2.
	
	Example:

	Input: [1,8,6,2,5,4,8,3,7]
	Output: 49
	
 */
public class _11_Container_With_Most_Water {

	public static void main(String[] args) {

		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(new _11_Container_With_Most_Water().maxArea(height));
	}
	
	public int maxArea(int[] height) {
        
        int n = height.length - 1;
        
        if(n < 1)
            return 0;
        
        int area = 0;
        
        int i = 0;
        
        while(i < n){
            
            int tmp = Math.min(height[i], height[n]) * (n - i);
            
            area = Math.max(area, tmp);
            
            if(height[i] < height[n])
                i++;
            
            else
                n--;
        }
        
        return area;
    }
}
