import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;


public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class Position {
        int r, c, broke;
        
        Position(int r, int c, int broke) {
            this.r = r;
            this.c = c;
            this.broke = broke;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Deque<Position> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        q.add(new Position(0,0,0));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            
            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.broke;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                
                if (arr[nr][nc] == 1) {
                    q.addLast(new Position(nr, nc, cur.broke + 1));
                } else {
                    q.addFirst(new Position(nr, nc, cur.broke));
                }
                
                visited[nr][nc] = true;
            }
        }
        
        return 0;
    }
}