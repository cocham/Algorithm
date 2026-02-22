import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int minCnt = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                check(i,j);
            }
        }
        
        System.out.print(minCnt);
    }
    
    static void check(int row, int col) {
        int r = 0;
        int c = 0;
        char[][] chess = new char[8][8];

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                chess[r][c] = arr[i][j];
                c++;
            }
            c = 0;
            r++;
        }
        
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (chess[i][j] != 'B') {
                            cnt++;
                        }
                    } else if (j % 2 != 0) {
                        if (chess[i][j] != 'W') {
                            cnt++;
                        }
                    }
                }
                if (i % 2 != 0) {
                    if (j % 2 == 0) {
                        if (chess[i][j] != 'W') {
                            cnt++;
                        }
                    } else if (j % 2 != 0) {
                        if (chess[i][j] != 'B') {
                            cnt++;
                        }
                    }
                }
            }
        }
        
        minCnt = Math.min(minCnt, Math.min(cnt, 64 - cnt));
    }
}
