import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n + 1];
            for (int i = 1; i <= 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sb.append(calc(arr, n)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int calc(int[][] arr, int n) {
        int[][] dp = new int[3][n + 1];
        
        dp[1][1] = arr[1][1];
        dp[2][1] = arr[2][1];
        
        //0 = 안뗀다 1 = 윗행을 뗀다(1행) 2 = 아래행을 뗀다(2행)
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
            dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]) + arr[2][i];
        }
        
        return Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n]);
    }
}
