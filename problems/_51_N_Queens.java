package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
 * no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
public class _51_N_Queens {

	private static int count;
	
	public static void main(String[] args) {

		int n = 4;
		
		List<List<String>> result = new _51_N_Queens().solveNQueens(n);
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.println(result.get(i).get(j));
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println("Count : " + count);
		
	}
	
	public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<List<String>>();
		
		int board[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
        
		count = 0;
		
		solveUtil(result, n, board, 0);
		
		return result;
        
    }
    
    public boolean solveUtil(List<List<String>> result, int a, int board[][], int col) {
		
		if(col == a) {
			count++;
			List<String> tmp = new ArrayList<>();
			for (int i = 0; i < a; i++) {
				String str = "";
				for (int j = 0; j < a; j++) {
					if(board[i][j] == 0)
						str = str + ".";
					
					else
						str = str + "Q";
				}
				
				tmp.add(str);
			}
			
			result.add(tmp);
			return true;
		}
		
		boolean res = false;
		
		for (int i = 0; i < a; i++) {
			
			if(isSafe(board, i, col, a)) {
				
				board[i][col] = 1;
				
				res = solveUtil(result, a, board, col + 1) || res;
				
				board[i][col] = 0;
			}
		}
		
		return res;
	} 

	public boolean isSafe(int board[][], int row, int col, int a) {
		
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
		for (int i = row, j = col; i < a && j >=0 ; i++, j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}

}
