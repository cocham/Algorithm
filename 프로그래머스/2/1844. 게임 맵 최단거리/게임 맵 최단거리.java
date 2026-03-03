import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int n, m;
    
    static class Position {
        int r, c, step;
        
        Position(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new Position(0,0,1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.r == n - 1 && cur.c == m - 1) {
                return cur.step;
            }
            
            for (int i = 0; i < 4; i++) {
                int mr = cur.r + dr[i];
                int mc = cur.c + dc[i];
                
                if (mr < 0 || mr >= n || mc < 0 || mc >= m) continue;
                if (visited[mr][mc]) continue;
                if (maps[mr][mc] == 0) continue;
                
                q.add(new Position(mr, mc, cur.step + 1));
                visited[mr][mc] = true;   
            }   
        }
        
        return -1;
    }
}
