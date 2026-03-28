import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][3];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][3];
        
        int answer = Integer.MAX_VALUE;
        for (int s = 0; s < 3; s++) {
            for (int i = 0; i < 3; i++) {
                if (i == s) {
                    dp[1][i] = arr[1][i];
                } else {
                    dp[1][i] = 1000 * 1000 + 1;
                }
            }
            
            for (int j = 2; j <= N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }
                
            for (int k = 0; k < 3; k++) {
                if (s != k) {
                    answer = Math.min(answer, dp[N][k]);
                }
            }
        }
        
        System.out.print(answer);
    }
}