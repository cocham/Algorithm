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
    static boolean[][] visited;
    
    static class Position {
        int r, c, broke;
        
        Position (int r, int c, int broke) {
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
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        int cnt = bfs(0,0,0);
        System.out.print(cnt);
    }
    
    static int bfs(int row, int col, int broke) {
        Deque<Position> q = new ArrayDeque<>();
        q.add(new Position(row, col, broke));
        visited[row][col] = true;
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.broke;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc] && arr[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.addLast(new Position(nr, nc, cur.broke + 1));
                    } else if (!visited[nr][nc] && arr[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.addFirst(new Position(nr, nc, cur.broke));
                    }
                }
            }
        }
        
        return 0;
        
    }
        
}
