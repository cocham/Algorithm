import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if(dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }
        
        System.out.println(dp[n][m]);
        System.out.println(sb.reverse().toString());
    } 
}