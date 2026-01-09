import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int[] xAxis = {-1, 1, 0, 0};
    static int[] yAxis = {0, 0, -1, 1};
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    static class Position {
        int row;
        int col;
        
        Position (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }
        
        int cnt = 0;
        List<Integer> houseResult = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    int houses = bfs(i,j);
                    houseResult.add(houses);
                    cnt++;
                }
            }
        }
        
        Collections.sort(houseResult);
        System.out.println(cnt);
        for (int i = 0; i < houseResult.size(); i++) {
            sb.append(houseResult.get(i)).append('\n');
        }
        System.out.print(sb);
    }
    
    static int bfs(int i, int j) {
        check[i][j] = true;
        Deque<Position> q = new ArrayDeque<>();
        q.add(new Position(i, j));
        int cnt = 0;
        
        while (!q.isEmpty()) {
            Position pos = q.poll();
            cnt++;

            for (int idx = 0; idx < 4; idx++) {
                int moveX = pos.row + xAxis[idx];
                int moveY = pos.col + yAxis[idx];
                
                if (moveX >= 0 && moveX <= n && moveY >= 0 && moveY <= n) {
                    if (arr[moveX][moveY] == 1 && !check[moveX][moveY]) {
                        q.add(new Position(moveX, moveY));
                        check[moveX][moveY] = true;
                    }
                }
            }
        } 
        
        return cnt;
    }
}