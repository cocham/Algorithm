import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, n);
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int start, int[][] arr, int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while (!q.isEmpty()) {
            int com = q.poll();
            visited[com] = true;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j] && arr[com][j] == 1) {
                    visited[j] = true;
                    q.add(j);
                }
            }

        }  
    }
}
