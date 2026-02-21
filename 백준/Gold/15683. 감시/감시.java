import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static int[][] arr;
    static ArrayList<CCTV> candidates = new ArrayList<>();
    static int safe = Integer.MAX_VALUE;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class CCTV {
        int r, c, type;
        
        CCTV (int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    
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
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    candidates.add(new CCTV(i, j, arr[i][j]));
                }
            }
        }
        
        dfs(0, arr);
        System.out.print(safe);
    }
    
    static void dfs(int depth, int[][] map) {
        if (depth == candidates.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            
            safe = Math.min(cnt, safe);
            return;
        }
        
        CCTV cur = candidates.get(depth);
        
        if (cur.type == 1) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);
                watch(cur.r, cur.c, d, newMap);
                dfs(depth + 1, newMap);
            }
        } else if (cur.type == 2) {
            for (int d = 0; d < 2; d++) {
                int[][] newMap = copyMap(map);
                if (d == 0) {
                    watch(cur.r, cur.c, 0, newMap);
                    watch(cur.r, cur.c, 1, newMap);
                } else {
                    watch(cur.r, cur.c, 2, newMap);
                    watch(cur.r, cur.c, 3, newMap);
                }
                dfs(depth + 1, newMap);
            }
        } else if (cur.type == 3) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);
                if (d == 0) {
                    watch(cur.r, cur.c, 0, newMap);
                    watch(cur.r, cur.c, 3, newMap);
                } else if (d == 1) {
                    watch(cur.r, cur.c, 1, newMap);
                    watch(cur.r, cur.c, 3, newMap);
                } else if (d == 2) {
                    watch(cur.r, cur.c, 1, newMap);
                    watch(cur.r, cur.c, 2, newMap);
                } else if (d == 3) {
                    watch(cur.r, cur.c, 0, newMap);
                    watch(cur.r, cur.c, 2, newMap);
                }
                dfs(depth + 1, newMap);
            }
        } else if (cur.type == 4) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);                
                for (int i = 0; i < 4; i++) {
                    if (i == d) continue;
                    watch(cur.r, cur.c, i, newMap);
                }
                dfs(depth + 1, newMap);
            }
        } else if (cur.type == 5) {
            int[][] newMap = copyMap(map);
            watch(cur.r, cur.c, 0, newMap);
            watch(cur.r, cur.c, 1, newMap);
            watch(cur.r, cur.c, 2, newMap);
            watch(cur.r, cur.c, 3, newMap);
            
            dfs(depth + 1, newMap);
        }
    }
    
    static void watch(int r, int c, int dir, int[][] map) {
        int nr = r;
        int nc = c;
        
        while(true) {
            nr += dr[dir];
            nc += dc[dir];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
            if (map[nr][nc] == 6) break;
            if (map[nr][nc] > 0 && map[nr][nc] < 6) {
                continue;
            }
            
            if (map[nr][nc] == 0) {
                map[nr][nc] = -1;
            } 
        }
    }
    
    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        
        return newMap;
    }
}
