package problems;

/**
  	Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	
	Example:
	
	X X X X
	X O O X
	X X O X
	X O X X
	
	After running your function, the board should be:
	
	X X X X
	X X X X
	X X X X
	X O X X

	Explanation:

	Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the 
	board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' 
	on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells 
	connected horizontally or vertically.
	
 */
public class _130_Surrounded_Regions {

	public static void main(String[] args) {
		
		char[][] board = {
					{'X', 'O', 'X', 'O', 'X', 'X'}, 
					{'X', 'O', 'X', 'X', 'O', 'X'}, 
					{'X', 'X', 'X', 'O', 'X', 'X'}, 
					{'O', 'X', 'X', 'X', 'X', 'X'}, 
					{'X', 'X', 'X', 'O', 'X', 'O'}, 
					{'O', 'O', 'X', 'O', 'O', 'O'}
				}; 
		
		new _130_Surrounded_Regions().solve(board);
		
		for (int i = 0; i < board.length; i++) 
        { 
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(board[i][j] + " ");  
                  
            System.out.println(""); 
        }
	}
	
	//Runtime: 4 ms, faster than 97.56% of Java online submissions for Surrounded Regions.
	//Using Flood-Fill Algo - Used in fill() function of Paint
	public void solve(char[][] board) {
        
        if(board==null || board.length==0 || board[0].length==0)
           return;
        
        int M = board.length;
        
        int N = board[0].length;
        
        // Step 1: Replace all 'O' with '-' 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                if (board[i][j] == 'O') 
                    board[i][j] = '-'; 
      
        // Call floodFill for all '-' lying on edges 
        
        for (int i = 0; i < M; i++) // Left side 
            if (board[i][0] == '-') 
                floodFillUtil(board, i, 0, '-', 'O');
        
        for (int i = 0; i < M; i++) // Right side 
            if (board[i][N - 1] == '-') 
                floodFillUtil(board, i, N - 1, '-', 'O');
        
        for (int i = 0; i < N; i++) // Top side 
            if (board[0][i] == '-') 
                floodFillUtil(board, 0, i, '-', 'O');
        
        for (int i = 0; i < N; i++) // Bottom side 
            if (board[M - 1][i] == '-') 
                floodFillUtil(board, M - 1, i, '-', 'O'); 

        // Step 3: Replace all '-' with 'X' 
        for (int i = 0; i < M; i++) 
            for (int j = 0; j < N; j++) 
                if (board[i][j] == '-') 
                    board[i][j] = 'X'; 
    }
    
	/**
	 * Detailed Flood Fill Alog : We first replace the color of current pixel, 
	 * 								then recur for 4 surrounding points.
	 * 
	 *  A recursive function to replace previous color 'prevC' at  '(x, y)' and all surrounding pixels 
	 *  of (x, y) with new color 'newC' and floodFil(screen[M][N], x, y, prevC, newC)
	 * 	1) If x or y is outside the screen, then return.
	 * 	2) If color of screen[x][y] is not same as prevC, then return
	 * 	3) Recur for north, south, east and west.
     * 		floodFillUtil(screen, x+1, y, prevC, newC);
     * 		floodFillUtil(screen, x-1, y, prevC, newC);
     * 		floodFillUtil(screen, x, y+1, prevC, newC);
     * 		floodFillUtil(screen, x, y-1, prevC, newC); 
	 * 
	 */
    private void floodFillUtil(char board[][], int x, int y, char prevV, char newV) {
        
        int M = board.length;
        
        int N = board[0].length;
        
        // Base cases 
        if (x < 0 || x >= M || y < 0 || y >= N) 
            return; 
              
        if (board[x][y] != prevV) 
            return; 
      
        // Replace the color at (x, y) 
        board[x][y] = newV; 
      
        // Recur for north, east, south and west 
        floodFillUtil(board, x + 1, y, prevV, newV);
        
        floodFillUtil(board, x - 1, y, prevV, newV); 
        
        floodFillUtil(board, x, y + 1, prevV, newV);
        
        floodFillUtil(board, x, y - 1, prevV, newV); 
    } 

}
