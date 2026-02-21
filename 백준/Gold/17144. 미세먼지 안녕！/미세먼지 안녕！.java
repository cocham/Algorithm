import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] arr;
    static int[][] temp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int airTop = -1;
    static int airBottom;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        temp = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1 && airTop == -1) {
                    airTop = i;
                    airBottom = i + 1;
                }
            }
        }
        
        while (T-- > 0) {
            spread();
            clean();
        }
        
        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != -1) {
                    totalDust += arr[i][j];
                }
            }
        }
        
        System.out.print(totalDust);
    }
    
    static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    int s = arr[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                        if (arr[nr][nc] == -1) continue;
                        
                        temp[nr][nc] += s;
                        arr[i][j] -= s;
                    }
                }
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    
        temp = new int[R][C];
        
    }
    
    static void clean() {
        for (int i = airTop - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0]; 
        }
        
        for (int j = 0; j < C - 1; j++) {
            arr[0][j] = arr[0][j + 1];
        }
        
        for (int i = 0; i < airTop; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        
        for (int j = C - 1; j > 0; j--) {
            arr[airTop][j] = arr[airTop][j - 1];
        }
        
        arr[airTop][1] = 0;
        
        for (int i = airBottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        
        for (int j = 0; j < C - 1; j++) {
            arr[R - 1][j] = arr[R - 1][j + 1];
        }
        
        for (int i = R - 1; i > airBottom; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        
        for (int j = C - 1; j > 1; j--) {
            arr[airBottom][j] = arr[airBottom][j - 1];
        }
        
        arr[airBottom][1] = 0;
    }
}