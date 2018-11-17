package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. 
 * Note that beginWord is not a transformed word.
 * Note:
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lower-case alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * Example 1:
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 	
 * Output: 5
 * 	
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * 	
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 	
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class _127_Word_Ladder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int count = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int j = 0; j < size; j++){
                String word = queue.remove();
                
                if(word.equals(endWord)){
                    return count;
                }
                
                for(int i = 0; i < word.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c != word.charAt(i)){
                            char[] s = word.toCharArray();
                            s[i] = c;
                            String trans = new String(s);
                            
                            if(wordList.contains(trans)){
                                queue.add(trans);
                                wordList.remove(trans);
                            }
                        }
                    }
                }
            }
            
            count++;
        }
        
        return 0;
    }
}
