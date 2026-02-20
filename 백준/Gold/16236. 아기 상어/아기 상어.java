import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static int sharkR, sharkC;
    static int sSize = 2;
    static int eaten = 0;
    
    static class Position {
        int r, c;
        
        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static class Fish {
        int r, c, dist;
        
        Fish (int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
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
        
        int totalTime = 0;
        while (true) {
            Fish target = bfs();
            
            if (target == null) break;
            
            totalTime += target.dist;
            arr[target.r][target.c] = 0;
            
            sharkR = target.r;
            sharkC = target.c;
            
            eaten++;
            if (eaten == sSize) {
                sSize ++;
                eaten = 0;
            }
        }
        
        System.out.print(totalTime);
    }
    
    static Fish bfs() {
        Queue<Position> q = new LinkedList<>();
        int[][] times = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                times[i][j] = -1;
            }
        }
        
        q.add(new Position(sharkR, sharkC));
        times[sharkR][sharkC] = 0;
        PriorityQueue<Fish> candidates = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) {
                if (o1.r == o2.r) {
                    return o1.c - o2.c;
                }
                return o1.r - o2.r;
            }
            return o1.dist - o2.dist;
        });
        
        while (!q.isEmpty()) {
            Position cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (arr[nr][nc] > sSize) continue;
                
                if (times[nr][nc] == -1) {
                    times[nr][nc] = times[r][c] + 1;
                    q.add(new Position(nr, nc));
                    
                    if (arr[nr][nc] != 0 && arr[nr][nc] < sSize) {
                        candidates.add(new Fish(nr, nc, times[nr][nc]));
                    }
                }
            }
        }
        
        if (candidates.isEmpty()) return null;
        
        return candidates.poll();
    }
}