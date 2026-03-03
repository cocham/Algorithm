import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] islandVisited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int minBridge = Integer.MAX_VALUE;
    
    static class Position {
        int r, c;
        
        Position (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Bridge {
        int r, c, step;
        
        Bridge (int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        islandVisited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !islandVisited[i][j]) {
                    islandBfs(i,j,islandId);
                    islandId++;
                }
            }
        }
        
        for (int id = 2; id < islandId; id++) {
            rootBfs(id);
        }
        
        System.out.print(minBridge);
    }
    
    static void rootBfs(int standId) {
        Queue<Bridge> q = new LinkedList<>();
        boolean[][] bridgeVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == standId) {
                    q.add(new Bridge(i,j,0));
                    bridgeVisited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Bridge cur = q.poll();
            
            if (cur.step >= minBridge) continue;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (bridgeVisited[nr][nc]) continue;
                
                if (arr[nr][nc] == 0) {
                    q.add(new Bridge(nr, nc, cur.step + 1));
                    bridgeVisited[nr][nc] = true;
                } else if (arr[nr][nc] != 0 && arr[nr][nc] != standId) {
                    minBridge = Math.min(minBridge, cur.step);
                    return;
                } 
            }
        }
    }
    
    static void islandBfs(int i, int j, int id) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(i,j));
        islandVisited[i][j] = true;
        arr[i][j] = id;
        
        while(!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (islandVisited[nr][nc]) continue;
                if (arr[nr][nc] == 0) continue;
                
                arr[nr][nc] = id;
                islandVisited[nr][nc] = true;
                q.add(new Position(nr, nc));
            }
        }
    }
}
