import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] mdr = {-1,1,0,0};
    static int[] mdc = {0,0,-1,1};
    static int K, W, H;
    static int[][] arr;
    static boolean[][][] visited;
    
    static class Position {
        int r;
        int c;
        int step;
        int kCnt;
        
        Position(int r, int c, int step, int kCnt) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.kCnt = kCnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = bfs();
        System.out.print(cnt);

    }
    
    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,0,0));
        visited[0][0][0] = true;
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.r == H - 1 && cur.c == W - 1) {
                return cur.step;
            }
            
            if (cur.kCnt < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    int kCnt = cur.kCnt + 1;
                    
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        if (!visited[nr][nc][kCnt] && arr[nr][nc] == 0) {
                            visited[nr][nc][kCnt] = true;
                            q.add(new Position(nr, nc, cur.step + 1, kCnt));
                        }
                    }
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + mdr[i];
                int nc = cur.c + mdc[i];
                
                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    if (!visited[nr][nc][cur.kCnt] && arr[nr][nc] == 0) {
                        visited[nr][nc][cur.kCnt] = true;
                        q.add(new Position(nr, nc, cur.step + 1, cur.kCnt));
                    }
                }
            }

        }

        return -1;
    }
}
