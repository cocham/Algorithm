import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
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
        
        while(true) {
            boolean[][] visited = new boolean[N][N];
            boolean isMoved = false;
            
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
        ArrayList<int[]> group = new ArrayList<>();
        
        visited[r][c] = true;
        q.add(new int[]{r, c});
        group.add(new int[]{r, c});
        
        int sum = arr[r][c];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                            
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                
                int diff = Math.abs(arr[cur[0]][cur[1]] - arr[nr][nc]);
                if (diff >= L && diff <= R) {
                    q.add(new int[]{nr, nc});
                    group.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    sum += arr[nr][nc];
                }
            }
        }
        
        if (group.size() > 1) {
            int people = sum / group.size();
            for (int i = 0; i < group.size(); i++) {
                int[] country = group.get(i);
                int curR = country[0];
                int curC = country[1];
            
                arr[curR][curC] = people;
            }
            
            return true;
        }

        return false;
    }
}