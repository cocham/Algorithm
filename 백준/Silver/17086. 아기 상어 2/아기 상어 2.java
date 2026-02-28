import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] arr;
    static Queue<Position> q = new LinkedList<>();
    static int[] dr = {-1,1,0,0,-1,-1,1,1};
    static int[] dc = {0,0,-1,1,1,-1,1,-1};
    static boolean[][] visited;
    
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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(new Position(i,j));
                    visited[i][j] = true;
                }
            }
        }
        
        bfs();
        int maxDis = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDis = Math.max(maxDis, arr[i][j]);
            }
        }
        
        System.out.print(maxDis - 1);
    }
    
    static void bfs() {
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                
                if (arr[nr][nc] == 0) {
                    arr[nr][nc] = arr[cur.r][cur.c] + 1;
                    q.add(new Position(nr, nc));
                }
            }
        }
    }
}
