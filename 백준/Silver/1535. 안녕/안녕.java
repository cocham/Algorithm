import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] lose = new int[N + 1];
        int[] joy = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lose[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][100];
        
        for (int i = 1; i <= N; i++) {
            for (int b = 1; b <= 99; b++) {
                if (lose[i] > b) {
                    dp[i][b] = dp[i - 1][b];
                } else {
                    dp[i][b] = Math.max(dp[i - 1][b], joy[i] + dp[i - 1][b - lose[i]]);
                }
            }
        }
        
        System.out.print(dp[N][99]);
    }
}