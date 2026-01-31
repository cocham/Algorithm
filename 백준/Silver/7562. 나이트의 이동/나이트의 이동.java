import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, -2, 2, -1, 1};
    static int I;
    static boolean[][] visited;
    
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int desX = Integer.parseInt(st.nextToken());
            int desY = Integer.parseInt(st.nextToken());
            
            if (curX == desX && curY == desY) {
                sb.append(0).append('\n');
                continue;
            }
            
            visited[curX][curY] = true;
            sb.append(bfs(curX, curY, desX, desY)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int bfs(int curX, int curY, int desX, int desY) {
        Position pos = new Position(curX, curY, 0);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            if (curPos.x == desX && curPos.y == desY) {
                return curPos.step;
            } 
            
            for (int i = 0; i < 8; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                            
                if (moveX >= 0 && moveX < I && moveY >= 0 && moveY < I) {
                    if (!visited[moveX][moveY]) {
                        visited[moveX][moveY] = true;
                        q.add(new Position(moveX, moveY, curPos.step + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}