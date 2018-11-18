package problems;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	
	Example:
	
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	Given word = "ABCCED", return true.
	Given word = "SEE", return true.
	Given word = "ABCB", return false.
 */

public class _79_Word_Search {

public boolean exist(char[][] board, String word) {
        
        int n = word.length();
        
        int rows = board.length;
        
        if(rows < 1 || n < 1)
            return false;
        
        int cols = board[0].length;
        
        boolean visited[][] = new boolean[rows][cols];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(searchBoard(board, visited, rows, cols, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean searchBoard(char[][] board, boolean[][] visited, int rows, int cols, String word, int row, int col, int idx){
       
        if(isValid(board, visited, rows, cols, row, col, word.charAt(idx))) {
			
            visited[row][col] = true;
            
            if(idx == word.length() - 1)
                return true;
            
            else{
                
                if(searchBoard(board, visited, rows, cols, word, row, col + 1, idx + 1) || 
                   searchBoard(board, visited, rows, cols, word, row, col - 1, idx + 1) || 
                   searchBoard(board, visited, rows, cols, word, row + 1, col, idx + 1) || 
                   searchBoard(board, visited, rows, cols, word, row - 1, col, idx + 1)
                  )
                    return true;
                
            }
            
            visited[row][col] = false;
		 }
	  
		 return false;
       
    }
    
    public boolean isValid(char[][] board, boolean[][] visited, int rows, int cols, int row, int col, char ch){
        
         if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] == true || board[row][col] != ch)
            return false;
        
        return true;
    }
}
