import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int[][] arr;
    
    static class Money {
        int r, c, m;
        
        Money (int r, int c, int m) {
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int lose = daik();
            sb.append("Problem " + idx + ": " + lose).append('\n');
            idx++;
        }
        
        System.out.print(sb);
        
    }
    
    static int daik() {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Money> q = new PriorityQueue<>((a,b) -> a.m - b.m);
        q.add(new Money(0,0,arr[0][0]));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Money cur = q.poll();
            
            if (cur.r == n - 1 && cur.c == n - 1) {
                return cur.m;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                
                q.add(new Money(nr, nc, cur.m + arr[nr][nc]));
                visited[nr][nc] = true;
            }
        }
        
        return 0;
    }
}
