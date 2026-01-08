import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int M;
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int[] xAxis = {-1, 1, 0, 0};
    static int[] yAxis = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    
    static class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            check = new boolean[M][N];
            int K = Integer.parseInt(st.nextToken());
            int cnt = 0;
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            
            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    if (arr[a][b] == 1 && !check[a][b]) {
                        cnt++;
                        bfs(a,b);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void bfs(int x, int y) {
        check[x][y] = true;
        Deque<Position> adj = new ArrayDeque<>();
        adj.add(new Position(x, y));
        
        while(!adj.isEmpty()) {
            Position cur = adj.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = cur.x + xAxis[i];
                int moveY = cur.y + yAxis[i];
                
                if (moveX >= 0 && moveX < M && moveY >= 0 && moveY < N) {
                    if (arr[moveX][moveY] == 1 && !check[moveX][moveY]) {
                        adj.add(new Position(moveX, moveY));
                        check[moveX][moveY] = true;
                    }
                }
            }
        }
    }
}