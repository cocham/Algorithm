import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int sharkR, sharkC;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class Shark {
        int size, ateCnt; 
        
        Shark(int size, int ateCnt) {
            this.size = size;
            this.ateCnt = ateCnt;
        }
    }
    
    static class Fish implements Comparable<Fish> {
        int r, c, dist;
        
        Fish (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
        
        @Override 
        public int compareTo(Fish o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            }
            if (this.r != o.r) {
                return this.r - o.r;
            }
            return this.c - o.c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkR = i;
                    sharkC = j;
                    arr[i][j] = 0;
                }
            }
        }
        
        int sharkSize = 2;
        int eatCnt = 0;
        int totalTime = 0;
        
        while (true) {
            Fish target = findFish(sharkR, sharkC, sharkSize);
            
            if (target == null) break;
            
            totalTime += target.dist;
            arr[target.r][target.c] = 0;
            sharkR = target.r;
            sharkC = target.c;
            
            eatCnt++;

            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
        }
        
        System.out.print(totalTime);        
    }
    
    static Fish findFish(int row, int col, int s) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[row][col] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        ArrayList<Fish> candidates = new ArrayList<>();
    
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
            
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] != -1 || arr[nr][nc] > s) continue;
                
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[] {nr,nc});

                if (arr[nr][nc] != 0 && arr[nr][nc] < s) {
                    candidates.add(new Fish(nr, nc, dist[nr][nc]));
                }
            }
        }

        if (candidates.isEmpty()) return null;

        Collections.sort(candidates);
        return candidates.get(0);
    }
}
