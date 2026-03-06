import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       
        int totalTime = 0;
        while(true) {
            outAir();
            findCheese();
            totalTime++;
            if (isMelted()) {
                break;
            }
        }
        
        System.out.print(totalTime);
    }
    
    static void outAir() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        arr[0][0] = -1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] != 1) {
                    arr[nr][nc] = -1;
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
    static void findCheese() {   
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    int connect = 0;
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if (arr[nr][nc] == -1) connect++;
                    }    
                    
                    if (connect >= 2) {
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] melt = q.poll();
            
            arr[melt[0]][melt[1]] = -1;
        }
    }
    
    static boolean isMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
