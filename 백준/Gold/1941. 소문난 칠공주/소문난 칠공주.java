import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static char[][] arr = new char[5][5];
    static int cnt = 0;
    static int[] selected = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        dfs(0, 0, 0);
        System.out.print(cnt);
    }
    
    static void dfs(int depth, int start, int sCnt) {
        if (depth == 7) {
            if (sCnt >= 4 && checkAdj()) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;

            selected[depth] = i;
            
            int nextS = arr[row][col] == 'S' ? sCnt + 1 : sCnt;

            dfs(depth + 1, i + 1, nextS);

        }
    }

    static boolean checkAdj() {
        int pcnt = 0;
        boolean[][] picked = new boolean[5][5];
        boolean[][] visited  = new boolean[5][5];

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<Integer> q = new LinkedList<>();
        q.add(selected[0]);
        visited[selected[0] / 5][selected[0] % 5] = true;
        pcnt++;

        for (int i = 0; i < 7; i++) {
            int r = selected[i] / 5;
            int c = selected[i] % 5;
            picked[r][c] = true;
        }
        
        while (!q.isEmpty()) {
            int p = q.poll();

            int r = p / 5;
            int c = p % 5;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                    if (picked[nr][nc] && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        pcnt++;
                        q.add(nr * 5 + nc);
                    }
                }
            }
        }

        return pcnt == 7;

    }
}