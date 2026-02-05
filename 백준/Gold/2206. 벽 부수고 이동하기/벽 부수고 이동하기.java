
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    
    static class Position {
        int x;
        int y;
        int step;
        boolean destroyed;

        Position(int x, int y, int step, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.destroyed = destroyed;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        
        System.out.print(bfs(0,0));
    }
    
    static int bfs(int start, int end) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(start, end, 1, false));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            if (curPos.x == N - 1 && curPos.y == M - 1) {
                return curPos.step;
            } 
            
            for (int i = 0; i < 4; i++) {
                int mx = curPos.x + dx[i];
                int my = curPos.y + dy[i];
                int state = curPos.destroyed ? 1 : 0;
                
                if (mx >= 0 && mx < N && my >= 0 && my < M) {
                   if (map[mx][my] == 0) {
                        if (!visited[mx][my][state]) {
                            visited[mx][my][state] = true;
                            q.add(new Position(mx, my, curPos.step + 1, curPos.destroyed));
                        }
                    } else if (map[mx][my] == 1) {
                       if (!visited[mx][my][1] && !curPos.destroyed) {
                           visited[mx][my][1] = true;
                           q.add(new Position(mx, my, curPos.step + 1, true));
                       }
                   }
                }
            }
        }
        
        return -1;
    }
}
