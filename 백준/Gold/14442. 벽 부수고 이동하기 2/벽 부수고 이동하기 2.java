import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int N;
    static int M;
    static int K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static class Position {
        int x;
        int y;
        int step;
        int crushCnt;
        
        Position (int x, int y, int step, int crushCnt) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.crushCnt = crushCnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int time = bfs();
        if (time < 0) {
            System.out.print(-1);
        } else {
            System.out.print(time);
        }
    }
    
    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,1,0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.step;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nextK = cur.crushCnt + 1;
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && nextK <= K && !visited[nx][ny][nextK]) {
                        q.add(new Position(nx, ny, cur.step + 1, nextK));
                        visited[nx][ny][nextK] = true;
                    } else if (map[nx][ny] == 0 && !visited[nx][ny][cur.crushCnt]) {
                        q.add(new Position(nx, ny, cur.step + 1, cur.crushCnt));
                        visited[nx][ny][cur.crushCnt] = true;
                    }
                }
            } 
        }
        
        return -1;
    }
}
