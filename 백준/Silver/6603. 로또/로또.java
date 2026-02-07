import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            arr = new int[K];
            visited = new boolean[K];
            for (int k = 0; k < K; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int idx, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < K; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append('\n');
            return;
        }

        for (int i = idx; i < K; i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
        
    }
}