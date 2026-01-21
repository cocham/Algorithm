import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fst = br.readLine();
        String sec = br.readLine();
        int n = fst.length();
        int m = sec.length();
        
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (fst.charAt(i - 1) != sec.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        
        System.out.print(dp[n][m]);
        
    }
}