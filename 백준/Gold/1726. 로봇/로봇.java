import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dr = {0,0,0,1,-1}; //동서남북
    static int[] dc = {0,1,-1,0,0};
    static int[][] turnDir = {
        {},
        {3,4},
        {3,4},
        {1,2},
        {1,2}
    };
    static int M, N;
    static int[][] arr;
    static boolean[][][] visited;
    static Queue<Position> q = new LinkedList<>();
    static int lastR, lastC, lastD;
    
    static class Position {
        int r, c, dir, cnt;
        
        Position (int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        visited = new boolean[M][N][5];
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int startD = Integer.parseInt(st.nextToken());
        q.add(new Position(startR, startC, startD, 0));
        st = new StringTokenizer(br.readLine());
        lastR = Integer.parseInt(st.nextToken()) - 1;
        lastC = Integer.parseInt(st.nextToken()) - 1;
        lastD = Integer.parseInt(st.nextToken());
        System.out.print(bfs());
    }
    
    static int bfs() {
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.r == lastR && cur.c == lastC && cur.dir == lastD) {
                return cur.cnt;
            }
            
            int dir = cur.dir;
            
            for (int k = 1; k <= 3; k++) {
                int nr = cur.r + dr[dir] * k;
                int nc = cur.c + dc[dir] * k;
                
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) break;
                if (arr[nr][nc] == 1) break;
                
                if (!visited[nr][nc][dir] && arr[nr][nc] == 0) {
                    visited[nr][nc][dir] = true;
                    q.add(new Position(nr, nc, dir, cur.cnt + 1));
                }
            }
            
            for (int d : turnDir[dir]) {
                if (!visited[cur.r][cur.c][d]) {
                    visited[cur.r][cur.c][d] = true;
                    q.add(new Position(cur.r, cur.c, d, cur.cnt + 1));
                }
            }
        }
        
        return 0;
    }
}