import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N, M;
    static int[][] arr;
    
    static class Position {
        int r, c, step, broken;
        
        Position (int r, int c, int step, int broken) {
            this.r = r;
            this.c = c;
            this.step = step;
            this.broken = broken;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.print(bfs());
    }
    
    static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,1,0));
        visited[0][0][0] = true;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int broken = cur.broken;
            
            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.step;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                
                if (arr[nr][nc] == 0) {
                    if (!visited[nr][nc][broken]) {
                        q.add(new Position(nr, nc, cur.step + 1, cur.broken));
                        visited[nr][nc][broken] = true;
                    }
                } else if (arr[nr][nc] == 1 && !visited[nr][nc][1] && broken == 0) {
                        q.add(new Position(nr, nc, cur.step + 1, 1));
                        visited[nr][nc][1] = true;
                    
                }
            }
        }
        
        return -1;
    }
}