import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] ans = new int[n + 1];
        ans[n] = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] != nums[i + 1]) {
                ans[i] = i + 1;
            } else {
                ans[i] = ans[i + 1];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(' ');
        }
        
        System.out.print(sb);
    }
}