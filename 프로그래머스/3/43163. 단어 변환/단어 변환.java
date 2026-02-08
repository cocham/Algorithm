import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;
    
    static class Word {
        String word;
        int step;
        
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        return bfs(begin, target, words);
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) {
                return cur.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int cnt = 0;
                
                for (int j = 0; j < word.length(); j++) {
                    if (cur.word.charAt(j) == word.charAt(j)) {
                        cnt++;
                    }
                }
                
                if (cnt == word.length() - 1 && !visited[i]) {
                    q.add(new Word(word, cur.step + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}