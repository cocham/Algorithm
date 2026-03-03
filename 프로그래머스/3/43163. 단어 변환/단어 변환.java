import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int size;
    
    static class Word {
        String word;
        int step;
        
        Word(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {        
        size = begin.length();
        return bfs(begin, target, words);
        
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.add(new Word(begin, 0));
        while (!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) {
                return cur.step;
            }
            
            String word = cur.word;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                
                int sameCnt = 0;
                String comp = words[i];
                for (int s = 0; s < size; s++) {
                    if (word.charAt(s) == comp.charAt(s)) {
                        sameCnt++;
                    }
                }
                
                if (sameCnt == size - 1) {
                    q.add(new Word(comp, cur.step + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}