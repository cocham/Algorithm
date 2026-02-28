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
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                int idx = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                arr[idx] = score;
            }
            
            int cnt = 1;
            int cutline = arr[1];
            
            for (int i = 2; i <= N; i++) {
                if (arr[i] < cutline) {
                    cnt++;
                    cutline = arr[i];
                }
            }
            
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
