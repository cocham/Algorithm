import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N,M;
    static int[][] arr;
    static int max = 0;
    static boolean[][] visited;
    
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
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                
                checkT(i,j);
            }
        }

        System.out.print(max);
                
    }
    
    static void dfs(int r, int c, int slot, int sum) {
        if (slot == 4) {
            max = Math.max(sum, max);
            return;
        }
        
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue;
            
            visited[nr][nc] = true;
            dfs(nr, nc, slot + 1, sum + arr[nr][nc]);
            visited[nr][nc] = false;
        }
    }
    
    static void checkT(int r, int c) {
        int[][][] shapes = {
            {{0,1}, {0,2}, {1,1}}, //ㅜ
            {{0,1}, {0,2}, {-1,1}}, //ㅗ        
            {{1,0}, {2,0}, {1,1}}, //ㅏ               
            {{0,1}, {-1,1}, {1,1}} //ㅓ
        } ;
    
        
        for (int[][] shape : shapes) {
            boolean valid = true;
            int sum = arr[r][c];

            for (int[] d : shape) {
                int nr = r + d[0];
                int nc = c + d[1];
            
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    valid = false;
                    break;
                }
            
                sum += arr[nr][nc];
            }
            
            if (valid) {
                max = Math.max(sum, max);
            }
        }
    }
}
