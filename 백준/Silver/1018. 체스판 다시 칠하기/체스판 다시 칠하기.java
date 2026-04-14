import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] arr;
    static int minCnt = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                check(i, j);
            }
        }
        
        System.out.print(minCnt);
    }
    
    static void check(int r, int c) {

        int cnt = 0;
        
        for (int i = r; i < r + 8; i++) {
            for (int j = c; j < c + 8; j++) {
                char expect = (i + j) % 2 == 0 ? 'W' : 'B';
               
                if (arr[i].charAt(j) != expect) {
                    cnt++;
                }
            }
        }
        
        minCnt = Math.min(minCnt, Math.min(cnt, 64 - cnt));
    }
}
