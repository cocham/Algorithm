import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        } 
        
        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i];
            for (int k = coin; k <= K; k++) {
                dp[k] += dp[k - coin];
            }
        }
        
        System.out.print(dp[K]);

    } 
}