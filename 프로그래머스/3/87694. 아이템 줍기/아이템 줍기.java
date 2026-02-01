import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Position {
        int x;
        int y;
        int step;
        
        Position(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        map = new int[101][101];

        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int x2 = rect[2] * 2;
            int y1 = rect[1] * 2;
            int y2 = rect[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i > x1 && i < x2 && j > y1 && j < y2) {
                        map[i][j] = 2;
                    } else {
                         if(map[i][j] != 2) {
                             map[i][j] = 1;
                         }
                    }
                }
            }
        }
        
        return bfs(characterX, characterY, itemX, itemY) / 2;
    }
    
    static int bfs(int chX, int chY, int itX, int itY) {
        Position pos = new Position(chX, chY, 0);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            if (curPos.x == itX && curPos.y == itY) {
                return curPos.step;
            }
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 1 && moveX <= 100 && moveY >= 1 && moveY <= 100) {
                    if (!visited[moveX][moveY] && map[moveX][moveY] == 1) {
                        q.add(new Position(moveX, moveY, curPos.step + 1));
                        visited[moveX][moveY] = true;
                    }
                }
            }
        }
        
        return 0;
    }
}