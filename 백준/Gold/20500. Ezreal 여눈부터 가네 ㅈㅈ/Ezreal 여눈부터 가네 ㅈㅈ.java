import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.print(0);
            return;
        }
        
        long[][] dp = new long[N + 1][3];
        dp[1][1] = 1;
        dp[1][2] = 1;
        
        for (int l = 2; l < N; l++) {
            dp[l][0] = (dp[l - 1][1] + dp[l - 1][2]) % MOD;
            dp[l][1] = (dp[l - 1][0] + dp[l - 1][2]) % MOD;
            dp[l][2] = (dp[l - 1][0] + dp[l - 1][1]) % MOD;
        }
        
        System.out.print(dp[N-1][1]);
    }
}