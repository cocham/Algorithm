import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N, M;
    static int G;
    static int R;
    static int[][] arr;
    static int[] selected = new int[10];
    static int flowerMax = 0;
    static ArrayList<Position> candidates = new ArrayList<>();
    
    static class Position {
        int r, c;
        
        Position (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    candidates.add(new Position(i,j));
                }
            }
        }
        
        dfs(0,0,0);
        System.out.print(flowerMax);
    }
    
    static void dfs(int idx, int gCnt, int rCnt) {
        if (gCnt == G && rCnt == R) {
            bfs();
            return;
        }
        
        if (idx == candidates.size()) {
            return;
        }
        
        if (gCnt < G) {
            selected[idx] = 3;
            dfs(idx + 1, gCnt + 1, rCnt);
            selected[idx] = 0;
        }
        
        if (rCnt < R) {
            selected[idx] = 4;
            dfs(idx + 1, gCnt, rCnt + 1);
            selected[idx] = 0;
        }
        
        dfs(idx + 1, gCnt, rCnt);
    }
    
    static void bfs() {
        Queue<Position> q = new LinkedList<>();
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int[][] times = new int[N][M];
        int[][] states = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                states[i][j] = arr[i][j];
                times[i][j] = -1;
            }
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            if (selected[i] == 3 || selected[i] == 4) {
                Position pos = candidates.get(i);
                int r = pos.r;
                int c = pos.c;
                states[r][c] = selected[i];
                times[r][c] = 0;
                q.add(pos);
            }
        }
        
        int flowerCnt = 0;
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            
            if (states[r][c] == 5) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (states[nr][nc] == 0) continue;
                
                if (times[nr][nc] == -1) {
                    states[nr][nc] = states[r][c];
                    times[nr][nc] = times[r][c] + 1;
                    q.add(new Position(nr, nc));
                } else if (states[nr][nc] != states[r][c] && times[nr][nc] == times[r][c] + 1 && states[nr][nc] != 5) {
                    states[nr][nc] = 5;
                    flowerCnt++;
                }
            }
        }
        
        flowerMax = Math.max(flowerMax, flowerCnt);
    }
}
