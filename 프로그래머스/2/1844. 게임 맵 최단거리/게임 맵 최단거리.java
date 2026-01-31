import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {0,0,1,-1}; //동서남북
    static int[] dy = {1,-1,0,0};
    static int ans = 0;
    static int N;
    static int M;
    static int[][] maps2;
    
    static class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        maps2 = maps;
        
        bfs(0,0);
        
        
        ans = maps2[N - 1][M - 1];
        
        if (ans == 1) {
            return -1;
        }
        return ans;
    }
    
    static void bfs(int x, int y) {
        Position pos = new Position(x,y);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while (!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                    if (maps2[moveX][moveY] == 1) {
                        Position newPos = new Position(moveX, moveY);
                        q.add(newPos);
                        maps2[moveX][moveY] = maps2[curPos.x][curPos.y] + 1;
                    }
                }
            }
        }
    }
}