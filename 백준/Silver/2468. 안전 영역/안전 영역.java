import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
       
    static class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        for (int h = 0; h <= 100; h++) {
            visited = new boolean[N][N];
            int curCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > h && !visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i,j,h);
                        curCnt++;
                    }
                }
            }
            
            cnt = Math.max(curCnt, cnt);
        }
        
        System.out.print(cnt);
    }
    
    static void bfs(int x, int y, int h) {
        Position pos = new Position(x, y);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                    if (arr[moveX][moveY] > h && !visited[moveX][moveY]) {
                        q.add(new Position(moveX, moveY));
                        visited[moveX][moveY] = true;
                        
                    }
                }
            }
        }
    }
}