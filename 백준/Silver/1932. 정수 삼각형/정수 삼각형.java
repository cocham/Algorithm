import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] triangle = new int[n + 1][];
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] part = new int[i];
            for (int j = 0; j < i; j++) {
                int a = Integer.parseInt(st.nextToken());
                part[j] = a;
            }
            triangle[i] = part;
        }
        
        int[][] dp = new int[n + 1][n + 1];
        dp[1][0] = triangle[1][0];
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (dp[n][j] > max) {
                max = dp[n][j];
            }
        }
       
        System.out.println(max);
    } 
}