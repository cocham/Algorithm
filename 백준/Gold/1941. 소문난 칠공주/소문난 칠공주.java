import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue; 

public class Main {
    static char[][] arr = new char[5][5];
    static int[] selected = new int[7];
    static int total;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        dfs(0,0,0);
        System.out.print(total);
    }
    
    static void dfs(int scnt, int idx, int depth) {
        if (depth == 7) {
            if (scnt >= 4) {
                if(bfs()) {
                    total++;
                }
            }
            return;
        }
        
        for (int i = idx; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            selected[depth] = i;

            if (arr[r][c] == 'S') {
                dfs(scnt + 1, i + 1, depth + 1);
            } else {
                dfs(scnt, i + 1, depth + 1);
            }
        }
    }
    
    static boolean bfs() {
        int[][] intArr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(intArr[i], 0);
        }
        for (int i = 0; i < selected.length; i++) {
            int idx = selected[i];
            int r = idx / 5;
            int c = idx % 5;
            
            intArr[r][c] = 1;
        }
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int startR = selected[0] / 5;
        int startC = selected[0] % 5;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        int connect = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (visited[nr][nc]) continue;                
                if (intArr[nr][nc] == 0) continue;
                
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                connect++;
            }
        }
        
        return connect == 7;
    }
}
