import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-2, -1, -2, -1, 1, 2, 2, 1};
    static int[] dc = {1, 2, -1, -2, -2, -1, 1, 2};
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int W;
    static int H;
    static int[][] arr;
    static boolean[][][] visited;
    static int K;
    
    static class Position {
        int x;
        int y;
        int step;
        int skill;
        
        Position(int x, int y, int step, int skill) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.skill = skill;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        visited = new boolean[H][W][K+1];
        
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                arr[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = bfs();
        if (cnt < 0) {
            System.out.print(-1);
        } else {
            System.out.print(cnt);
        }
    }
    
    static int bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,0,0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Position cur = q.poll();
            if (cur.x == H - 1 && cur.y == W - 1) {
                return cur.step;
            }
               
            if (cur.skill < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = cur.x + dr[i];
                    int nc = cur.y + dc[i];
                    int nextSkill = cur.skill + 1;
                    
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        if (!visited[nr][nc][nextSkill] && arr[nr][nc] == 0) {
                            q.add(new Position(nr, nc, cur.step + 1, nextSkill));
                            visited[nr][nc][nextSkill] = true;
                        }    
                    }
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.x + dx[i];
                int nc = cur.y + dy[i];
                
                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    if (!visited[nr][nc][cur.skill] && arr[nr][nc] == 0) {
                        q.add(new Position(nr, nc, cur.step + 1, cur.skill));
                        visited[nr][nc][cur.skill] = true;
                    }    
                }
            }
        }
        return -1;
    }
}