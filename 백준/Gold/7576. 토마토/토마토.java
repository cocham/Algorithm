import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int M,N;
    static int[][] arr;
    static Queue<Position> tomato = new LinkedList<>();
    
    static class Position {
        int r, c;
        Position (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    tomato.add(new Position(i,j));
                }
            }
        }
        
        bfs();
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                maxCnt = Math.max(maxCnt,arr[i][j]);
            }
        }
        System.out.print(maxCnt - 1);
    }
    
    static void bfs() {
        while(!tomato.isEmpty()) {
            Position cur = tomato.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (arr[nr][nc] == 0) {
                        tomato.add(new Position(nr, nc));
                        arr[nr][nc] = arr[cur.r][cur.c] + 1;
                    }
                }
            }
        }
    }
}
