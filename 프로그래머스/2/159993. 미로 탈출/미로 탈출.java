import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int n, m;

    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int stoL = bfs(maps, start[0], start[1], lever[0], lever[1]);
        if (stoL == -1) {
            return -1;
        }
        
        int ltoE = bfs(maps, lever[0], lever[1], end[0], end[1]);
        if (ltoE == -1) {
            return -1;
        }
        
        return stoL + ltoE;
    }
    
    static int bfs(String[] maps, int goR, int goC, int toR, int toC) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        boolean[][] visited = new boolean[n][m];
        int[][] time = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{goR, goC});
        visited[goR][goC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (r == toR && c == toC) {
                return time[toR][toC];
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr].charAt(nc) == 'X') continue;
                
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                time[nr][nc] = time[r][c] + 1;
                
            }
        }
        
        return -1;
    }
}