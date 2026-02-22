import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int[][] arr;
    static Queue<Ice> iceQ = new LinkedList<>();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] slice;
    
    static class Ice {
        int r, c;
        
        Ice (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        slice = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    iceQ.add(new Ice(i, j));
                }
            }
        }
        
        int year = 0;
        while (true) {
            if (iceQ.isEmpty()) {
                System.out.print(0);
                break;
            }
            if (isSeparate()) {
                System.out.print(year);
                break;
            }

            iceBfs();
            year++;
        }
    }
    
    static void iceBfs() {
        slice = new int[N][M];
        int size = iceQ.size();
        for (int i = 0; i < size; i++) {
            Ice cur = iceQ.poll();
            int waterCnt = 0;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (arr[nr][nc] == 0) {
                    waterCnt++;
                }
            }
            
            slice[cur.r][cur.c] = waterCnt;
            iceQ.add(cur);
        }     
        
        for (int i = 0; i < size; i++) {
            Ice cur = iceQ.poll();
            
            arr[cur.r][cur.c] -= slice[cur.r][cur.c];
            
            if (arr[cur.r][cur.c] < 0) {
                arr[cur.r][cur.c] = 0;
            } else if (arr[cur.r][cur.c] > 0) {
                iceQ.add(cur);
            }
        }   
    }
    
    static boolean isSeparate() {
        if (iceQ.isEmpty()) {
            return false;
        }
        
        visited = new boolean[N][M];
        Queue<Ice> bfsQ = new LinkedList<>();
        
        Ice cur = iceQ.peek();
        bfsQ.add(cur);
        visited[cur.r][cur.c] = true;
        int gcnt = 1;
        
        while (!bfsQ.isEmpty()) {
            Ice ice = bfsQ.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = ice.r + dr[i];
                int nc = ice.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (arr[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    gcnt++;
                    bfsQ.add(new Ice(nr,nc));
                }
            }
        }
        
        return gcnt < iceQ.size();
    }
}
