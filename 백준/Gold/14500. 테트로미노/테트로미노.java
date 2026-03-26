import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans = 0;
    
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
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, -1, -1, arr[i][j], 1);
                
                checkT(i, j);
            }
        }
              
        System.out.println(ans);
    }
    
    static void dfs(int r, int c, int prevR, int prevC, int sum, int depth) {
        if (depth == 4) {
            ans = Math.max(sum, ans);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (nr == prevR && nc == prevC) continue;
            
            dfs(nr, nc, r, c, sum + arr[nr][nc], depth + 1);
        }        
    }
    
    static void checkT(int r, int c) {
        // ㅜ
        if (r + 1 < N && c + 1 < M && c - 1 >= 0) {
            int sum = arr[r][c] + arr[r + 1][c] + arr[r][c + 1] + arr[r][c - 1];
            ans = Math.max(sum, ans);
        } 
        // ㅗ
        if (r - 1 >= 0 && c + 1 < M && c - 1 >= 0) {
            int sum = arr[r][c] + arr[r - 1][c] + arr[r][c + 1] + arr[r][c - 1];
            ans = Math.max(sum, ans);
        }
        // ㅓ
        if (c - 1 >= 0 && r - 1 >= 0 && r + 1 < N) {
            int sum = arr[r][c] + arr[r][c - 1] + arr[r - 1][c] + arr[r + 1][c];
            ans = Math.max(sum, ans);
        }
        // ㅏ
        if (c + 1 < M && r - 1 >= 0 && r + 1 < N) {
            int sum = arr[r][c] + arr[r][c + 1] + arr[r - 1][c] + arr[r + 1][c];
            ans = Math.max(sum, ans);
        }
    }
}