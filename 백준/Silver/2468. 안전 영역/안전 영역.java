import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
     
    static class Location {
        int x;
        int y;
        
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static void resetCheckArray() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(check[i], false);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        check = new boolean[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 1;
        for (int h = 1; h <= 100; h++) {
            resetCheckArray();
            int curCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int H = map[i][j];
                    if (H > h && !check[i][j]) {
                        bfs(h, new Location(i, j));
                        curCnt++;
                    }
                }
            }
            cnt = Math.max(curCnt, cnt);
        }
        
        System.out.println(cnt);
    }
    
    static void bfs(int standardH, Location location) {
        Deque<Location> adj = new ArrayDeque<>();
        adj.addLast(location);
        
        while (!adj.isEmpty()) {
            Location curLocation = adj.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curLocation.x + dx[i];
                int moveY = curLocation.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                     if (map[moveX][moveY] > standardH && !check[moveX][moveY]) {
                         adj.add(new Location(moveX, moveY));
                         check[moveX][moveY] = true;
                     }   
                }
            }
            
        }
    }
       
}