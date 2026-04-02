import java.util.*;

class Solution {
    static int n, m;
    static int sr, sc;
    static int er, ec;
    
    static class Position {
        int r, c, step;
        
        Position (int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    sr = i;
                    sc = j;
                } else if (board[i].charAt(j) == 'G') {
                    er = i;
                    ec = j;
                }
            }
        }
        
        int answer = bfs(board);
        return answer;
    }
    
    static int bfs(String[] board) {
        Queue<Position> q = new LinkedList<>();  
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Position(sr, sc, 0));
        visited[sr][sc] = true;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!q.isEmpty()) {
            Position cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            int step = cur.step;
            
            if (r == er && c == ec) {
                return step;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r;
                int nc = c;
                
                while (true) {
                    nr += dr[i];
                    nc += dc[i];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr].charAt(nc) == 'D') {
                        nr -= dr[i];
                        nc -= dc[i];
                        break;
                    }
                }
                
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Position(nr, nc, step + 1));
                }
            }
        }
        
        return -1;
    }
}