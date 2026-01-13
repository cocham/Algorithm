import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int W = 1; W <= K; W++) {
                if (weights[i] > W) {
                    dp[i][W] = dp[i-1][W];
                } else {
                    dp[i][W] = Math.max(dp[i-1][W], values[i] + dp[i-1][W - weights[i]]);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    } 
}