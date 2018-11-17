package problems;

public class _52_N_Queens_ii {

	private static int count = 0;
	
	public static void main(String[] args) {

		int n = 4;
		
		System.out.println(new _52_N_Queens_ii().totalNQueens(n));
		
	}
	    
    public int totalNQueens(int n) {
 
        int board[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
        
        count = 0;
        
		solveUtil(n, board, 0);
        
        return count;
        
    }
    
    public boolean solveUtil(int n, int board[][], int col){
        
        if(col == n){
            count++;
            return true;
        }
        
        boolean res = false;
		
		for (int i = 0; i < n; i++) {
			
			if(isSafe(board, i, col, n)) {
				
				board[i][col] = 1;
				
				res = solveUtil(n, board, col + 1) || res;
				
				board[i][col] = 0;
			}
		}
		
		return res;
    }
    
    public boolean isSafe(int board[][], int row, int col, int n) {
		
		//left side
		for (int i = 0; i < col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		//upper left diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		//lower left diagonal
		for (int i = row, j = col; i < n && j >=0 ; i++, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
}
