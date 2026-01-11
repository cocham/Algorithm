import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][][] arr;
    static Deque<Position> spread = new ArrayDeque<>();
    static int M;
    static int N;
    static int H;
    static int[] dx = {-1, 1, 0, 0, 0, 0}; //상하좌우앞뒤
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    
    static class Position {
        int h, n, m;
        
        Position (int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        
        for (int z = 0; z < H; z++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[z][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        for (int z = 0; z < H; z++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[z][n][m] == 1) {
                        spread.add(new Position(z, n, m));
                    }
                }
            }
        }
        
        bfs();
        int max = 0;
        for (int z = 0; z < H; z++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[z][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(arr[z][n][m], max);
                }
            }
        }
        
        System.out.println(max - 1);

    }
    
    static void bfs() {
        while (!spread.isEmpty()) {
            Position pos = spread.poll();
            
            for (int i = 0; i < 6; i++) {
                int moveX = pos.m + dx[i];
                int moveY = pos.n + dy[i];
                int moveZ = pos.h + dz[i];
                
                if (moveX >= 0 && moveX < M && moveY >= 0 && moveY < N && moveZ >= 0 && moveZ < H) {
                    if (arr[moveZ][moveY][moveX] == 0) {
                        arr[moveZ][moveY][moveX] = arr[pos.h][pos.n][pos.m] + 1;
                        spread.add(new Position(moveZ, moveY,  moveX));
                    } 
                }
            }
        }
    }
}