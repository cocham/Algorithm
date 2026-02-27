import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    
    static class Air {
        int r, c;
        
        Air (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        int lastCheeseCnt = 0;
        while (true) {
            int meltedCnt = melting();
            
            visited = new boolean[N][M];
            if (meltedCnt == 0) {
                System.out.println(time);
                System.out.println(lastCheeseCnt);
                break;
            }
            
            lastCheeseCnt = meltedCnt;
            time++;
        }
    }
    
    static int melting() {
        Queue<Air> q = new LinkedList<>();
        q.add(new Air(0,0));
        visited[0][0] = true;
        int melted = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!q.isEmpty()) {
            Air cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                
                if (arr[nr][nc] == 0) {
                    q.add(new Air(nr, nc));
                } else if (arr[nr][nc] == 1) {
                    arr[nr][nc] = 0;
                    melted++;
                }
            }
        }
        return melted;
    }
}
