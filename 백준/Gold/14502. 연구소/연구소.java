import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<int[]> walls = new ArrayList<>();
    static int maxSafe = 0;
    
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
                
                if (arr[i][j] == 0) {
                    walls.add(new int[]{i,j});
                }
            }
        }
        
        visited = new boolean[walls.size()];
        dfs(0, 0);
        System.out.print(maxSafe);
    }
    
    static void dfs(int start, int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        
        for (int i = start; i < walls.size(); i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    static void bfs() {
        Queue<int[]> viruses = new LinkedList<>();
        int[][] copy = new int[N][M];
        boolean[][] spread = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = arr[i][j];
                
                if (copy[i][j] == 2) {
                    spread[i][j] = true;
                    viruses.add(new int[]{i, j});
                }
            }
        }
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                int[] wall = walls.get(i);
                copy[wall[0]][wall[1]] = 1;
            }
        }
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!viruses.isEmpty()) {
            int[] virus = viruses.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = virus[0] + dr[i];
                int nc = virus[1] + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (spread[nr][nc]) continue;
                if (copy[nr][nc] == 1) continue;
                
                viruses.add(new int[]{nr, nc});
                spread[nr][nc] = true;
                copy[nr][nc] = 2;
            }
        }
        
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < M; j++) {
                if (copy[i][j] == 0) {
                    safe++;
                }
            }
        }
        
        maxSafe = Math.max(safe, maxSafe);
    }
}