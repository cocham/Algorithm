import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        dp[0] = 1;
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLen = -1;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        int currentLen = maxLen;
        for (int i = maxIdx; i >= 0; i--) {
            if (dp[i] == currentLen) {
                currentLen--;
                res.add(sequence[i]);
            }
        }

        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(" ");
        }
        System.out.println(maxLen);
        System.out.println(sb);
    }
}