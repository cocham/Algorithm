import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    static void bfs(int i, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int j = 0; j < computers.length; j++) {
                if (i == j) continue;
                if (visited[j]) continue;
                if (computers[cur][j] == 1) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
            
    }
}