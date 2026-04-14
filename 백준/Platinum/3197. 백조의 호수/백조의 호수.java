import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int sr = -1, sc = -1, er, ec;
    static boolean[][] swVisited;
    static Queue<int[]> nextSwans = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        swVisited = new boolean[R][C];
        
        Queue<int[]> waters = new LinkedList<>();
        Queue<int[]> swans = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j); 
                
                if (arr[i][j] == '.' || arr[i][j] == 'L') {
                    waters.add(new int[]{i, j});
                }
                
                if (arr[i][j] == 'L') {
                    if (sr == -1 && sc == -1) {
                        sr = i;
                        sc = j;
                        swans.add(new int[]{sr, sc});
                        swVisited[sr][sc] = true;
                    } else {
                        er = i;
                        ec = j;
                    }
                }
            }
        }
        
        int day = 0;
        while (true) {
            if (isMatch(swans)) {
                break;
            }
            waters = bfs(waters);
            swans = nextSwans;
            nextSwans = new LinkedList<>();
            day++;

        }
        
        System.out.print(day);        
    }
    
    static boolean isMatch(Queue<int[]> q) {
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (r == er && c == ec) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (swVisited[nr][nc]) continue;
                
                swVisited[nr][nc] = true;
                if (arr[nr][nc] != 'X') {
                    q.add(new int[]{nr, nc});
                } else {
                    nextSwans.add(new int[]{nr, nc});
                }

            }
        }

        return false;
    }
    
    
    static Queue<int[]> bfs(Queue<int[]> q) {
        Queue<int[]> nextWaters = new LinkedList<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (arr[nr][nc] == '.') continue;
                
                arr[nr][nc] = '.';
                nextWaters.add(new int[]{nr, nc});
            }
        }

        return nextWaters;
    }
}