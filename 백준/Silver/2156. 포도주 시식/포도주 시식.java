import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] quantity = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            quantity[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = quantity[1];
        int max = 0;

        if (n == 1) {
            max = dp[1];
        } else if (n >= 2) {
            dp[2] = quantity[1] + quantity[2];
            max = dp[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3] + quantity[i-1], dp[i-2]) + quantity[i], dp[i-1]);
            max = Math.max(dp[i], max);
        }
        
        System.out.println(max);
    }
}