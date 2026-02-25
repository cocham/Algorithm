import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    static int totalEmpty = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if (arr[i][j] == 2) {
                    virus.add(new int[]{i,j});
                } else if (arr[i][j] == 0) {
                    totalEmpty++;
                }
            }
        }
        
        dfs(0,0);
        if (minTime == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(minTime);
    }
    
    static void dfs(int idx, int depth) {
        if (depth == M) {
            bfs();
            return;
        } 
        
        for (int i = idx; i < virus.size(); i++) {
            int[] v = virus.get(i);
            int r = v[0];
            int c = v[1];
            
            arr[r][c] = 3;
            dfs(i + 1, depth + 1);
            arr[r][c] = 2;
        }
    }
    
    static void bfs() {
        int[][] time = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                time[i][j] = -1;
                if (arr[i][j] == 3) {
                    time[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int emptyCnt = 0;
        int changeTime = 0;
        while (!q.isEmpty()) {
            if (emptyCnt == totalEmpty) {
                break;
            }
            
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (arr[nr][nc] == 1) continue;
                if (time[nr][nc] == -1) {
                    time[nr][nc] = time[r][c] + 1;
                    q.add(new int[] {nr, nc});
                    if (arr[nr][nc] == 0) {
                        emptyCnt++;
                        changeTime = time[nr][nc];
                    }
                }
            }
        }
        
        if (emptyCnt == totalEmpty) {
            minTime = Math.min(changeTime, minTime);
        }
    }
}
