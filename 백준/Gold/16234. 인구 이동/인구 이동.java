import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int N, L, R;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int day = 0;
        while (true) {
            boolean isMoved = false;
            boolean[][] visited = new boolean[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j, visited)) {
                            isMoved = true;
                        }
                    }
                }
            }
            
            if (!isMoved) break;
            day++;
        }

        System.out.print(day);
    }
    
    static boolean bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();
        int unionP = arr[r][c];
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        visited[r][c] = true;   
        q.add(new int[]{r, c});
        union.add(new int[]{r, c});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                
                int diff = Math.abs(arr[cur[0]][cur[1]] - arr[nr][nc]);
            
                if (diff >= L && diff <= R){
                    q.add(new int[]{nr, nc});
                    union.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    unionP += arr[nr][nc];
                }    
            }
        }
        
        if (union.size() > 1) {
            int divideP = unionP / union.size();
            
            for (int[] country : union) {
                int R = country[0];
                int C = country[1];
                arr[R][C] = divideP;
            }
            
            return true;
        }
       return false;
    }
}
