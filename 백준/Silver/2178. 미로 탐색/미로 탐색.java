import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Position {
        int row;
        int col;
        
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        bfs(0, 0);
        System.out.println(arr[n - 1][m - 1]);
    } 
    
    static void bfs(int row, int col) {
        check[row][col] = true;
        Deque<Position> adj = new ArrayDeque<>();
        adj.add(new Position(row, col));
        
        while(!adj.isEmpty()) {
            Position cur = adj.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = cur.row + dx[i];
                int moveY = cur.col + dy[i];
                
                if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m) {
                    if (arr[moveX][moveY] == 1 && !check[moveX][moveY]) {
                        check[moveX][moveY] = true;
                        
                        arr[moveX][moveY] = arr[cur.row][cur.col] + 1;
                        adj.add(new Position(moveX, moveY));
                    }
                }
            }
        }
    }
}