import java.util.*;

class Solution {
    
    static class Position {
        int r, c, step;
        
        Position (int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    static int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int sr = 0, sc = 0;
        int lr = 0, lc = 0;
        int er = 0, ec = 0; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lr = i;
                    lc = j;
                } else if (maps[i].charAt(j) == 'E') {
                    er = i;
                    ec = j;
                } 
            }
        }
        
        int stol = bfs(sr, sc, lr, lc, maps);
        if (stol == -1) {
            return -1;
        }
        int ltoe = bfs(lr, lc, er, ec, maps);
        if (ltoe == -1) {
            return -1;
        }
        
        return stol + ltoe;
    }
    
    static int bfs(int sr, int sc, int er, int ec, String[] maps) {
        
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Position(sr, sc, 0));
        visited[sr][sc] = true;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int r = cur.r, c = cur.c, step = cur.step;
            
            if (r == er && c == ec) return step;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr].charAt(nc) != 'X') {
                    q.add(new Position(nr, nc, step + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}