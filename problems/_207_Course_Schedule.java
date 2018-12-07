package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  There are a total of n courses you have to take, labeled from 0 to n-1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
	which is expressed as a pair: [0,1]

	Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
	finish all courses?
	
	Example 1:
	
	Input: 2, [[1,0]] 
	Output: true
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0. So it is possible.
	
	Example 2:
	
	Input: 2, [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0, and to take course 0 you should
	             also have finished course 1. So it is impossible.
	Note:
	
	- The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
	  Read more about how a graph is represented.
	- You may assume that there are no duplicate edges in the input prerequisites.

 */
public class _207_Course_Schedule {

	public static void main(String[] args) {

	}
	
	//Runtime: 51 ms , Using BFS Traversal to detect loop
	public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null || prerequisites.length == 0 || numCourses == 0){
            return true;
        }

        int n = prerequisites.length;
        
        int[] preReqCount = new int[numCourses];
        
        Arrays.fill(preReqCount, 0);
        
        for(int i = 0; i < n; i++){
            preReqCount[prerequisites[i][0]]++;
        }
        
        Queue<Integer> qu = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(preReqCount[i] == 0)
                qu.add(i);
        }
        
        int complete = qu.size();
        
        while(!qu.isEmpty()){
            int tmp = qu.poll();
            for(int i = 0; i < n; i++){
                
                if(complete == numCourses)
                        return true;
                
                if(prerequisites[i][1] == tmp){
                    preReqCount[prerequisites[i][0]]--;
                    
                    if(preReqCount[prerequisites[i][0]] == 0){
                        complete++;
                        qu.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return false;
    }
	
	//Runtime: 8 ms, Using DFS Traversal to detect loop, if loop present then can not finish the course schedule
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 || len == 0){
            return true;
        }

        // use the map to store what courses depend on a course 
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else{
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }
        
        boolean[] visited = new boolean[numCourses]; 
        boolean[] recStack = new boolean[numCourses];
        
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);
        
        for (int i = 0; i < numCourses; i++) 
            if (!canFinishDFS(map, visited, recStack, i)) 
                return false; 
  
        return true; 
        
    }
    
    
    private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, boolean[] visited, boolean[] recStack, int i){
        
        if (recStack[i]) 
            return false; 
  
        if (visited[i]) 
            return true; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        
        List<Integer> list = map.get(i); 
        
        if(list != null){
            for (int c: list) 
                if (!canFinishDFS(map, visited, recStack, c)) 
                    return false; 
        }
        
        recStack[i] = false; 
  
        return true; 
    }

}
