import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int R;
    static int C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[] visited = new boolean[26];
    static char[][] board;
    static int maxCnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        dfs(0,0,1);
        System.out.print(maxCnt);
    }
    
    static void dfs(int r, int c, int cnt) { 
        
        visited[board[r][c] - 'A'] = true;
        maxCnt = Math.max(cnt, maxCnt);
        
        for (int i = 0; i < 4; i++) {
            int mr = r + dr[i];
            int mc = c + dc[i];
                
            if (mr >= 0 && mr < R && mc >= 0 && mc < C 
                && !visited[board[mr][mc] - 'A'])
            {    
                dfs(mr, mc, cnt + 1);
            }
        }
        
        visited[board[r][c] - 'A'] = false;
    }
    
}
