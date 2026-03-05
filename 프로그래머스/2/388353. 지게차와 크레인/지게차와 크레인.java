import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    static int n,m;
    static char[][] arr;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                arr[i][j] = '.';
            }
        }
        
        for (int i = 0; i < n; i++) {
            String s = storage[i];
            for (int j = 0; j < m; j++) {
                arr[i + 1][j + 1] = s.charAt(j);
            }
        }
        
        for (String r : requests) {
            char target = r.charAt(0);
            
            if (r.length() == 2) {
                for (int i = 0; i < n + 2; i++) {
                    for (int j = 0; j < m + 2; j++) {
                        if (arr[i][j] == target) {
                            arr[i][j] = '.';
                        }
                    }
                }
            }
            
            else {
                bfs(target);
            }
        }
        
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] != '.') {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static void bfs(char target) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 2][m + 2];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        
        ArrayList<int[]> bomb = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n + 2 || nc < 0 || nc >= m + 2) continue;
                if (visited[nr][nc]) continue;
                
                if (arr[nr][nc] == '.') {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                } else if (arr[nr][nc] == target) {
                    bomb.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        for (int i = 0; i < bomb.size(); i++) {
            int[] location = bomb.get(i);
            
            arr[location[0]][location[1]] = '.';
        }
        
    }
}