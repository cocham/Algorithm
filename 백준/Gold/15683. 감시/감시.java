import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    
    static class CCTV {
        int r, c, type; 
        
        CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
    
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<CCTV> cctvs = new ArrayList<>();
    static int safe = Integer.MAX_VALUE;
    
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
                    cctvs.add(new CCTV(i,j,arr[i][j]));
                }
            }
        }
        
        dfs(0, arr);
        System.out.print(safe);
    }
    
    // d = 상하좌우
    static void dfs(int idx, int[][] map) {
        if (idx == cctvs.size()) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            safe = Math.min(cnt, safe);
            return;
        }
        
        CCTV cctv = cctvs.get(idx);
        
        if (cctv.type == 1) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);
                watch(cctv, d, newMap);
                dfs(idx + 1, newMap);
            }
        } else if (cctv.type == 2) {
            for (int d = 0; d < 2; d++) {
                int[][] newMap = copyMap(map);
                if (d == 0) {
                    watch(cctv, 0, newMap);
                    watch(cctv, 1, newMap);
                } else {
                    watch(cctv, 2, newMap);
                    watch(cctv, 3, newMap);
                }
                dfs(idx + 1, newMap);
            }
        } else if (cctv.type == 3) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);
                if (d == 0) {
                    watch(cctv, 0, newMap);
                    watch(cctv, 3, newMap);
                } else if (d == 1) {
                    watch(cctv, 1, newMap);
                    watch(cctv, 3, newMap);
                } else if (d == 2) {
                    watch(cctv, 2, newMap);
                    watch(cctv, 1, newMap);
                } else if (d == 3) {
                    watch(cctv, 2, newMap);
                    watch(cctv, 0, newMap);
                }
                dfs(idx + 1, newMap);
            }
        } else if (cctv.type == 4) {
            for (int d = 0; d < 4; d++) {
                int[][] newMap = copyMap(map);
                if (d == 0) {
                    watch(cctv, 0, newMap);
                    watch(cctv, 2, newMap);
                    watch(cctv, 3, newMap);
                } else if (d == 1) {
                    watch(cctv, 0, newMap);
                    watch(cctv, 1, newMap);
                    watch(cctv, 3, newMap);
                } else if (d == 2) {
                    watch(cctv, 1, newMap);
                    watch(cctv, 2, newMap);
                    watch(cctv, 3, newMap);
                } else if (d == 3) {
                    watch(cctv, 0, newMap);
                    watch(cctv, 1, newMap);
                    watch(cctv, 2, newMap);
                }
                dfs(idx + 1, newMap);
            }
        } else if (cctv.type == 5) {
                int[][] newMap = copyMap(map);
                watch(cctv, 0, newMap);
                watch(cctv, 1, newMap);
                watch(cctv, 2, newMap);
                watch(cctv, 3, newMap);
                dfs(idx + 1, newMap);
        }
    }
    

    
    
    static void watch(CCTV cctv, int d, int[][] map) {
        int r = cctv.r;
        int c = cctv.c;
        
        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
            if (map[nr][nc] == 6) break;

            if (arr[nr][nc] == 0) {
                map[nr][nc] = -1; 
            }

            r = nr;
            c = nc;
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