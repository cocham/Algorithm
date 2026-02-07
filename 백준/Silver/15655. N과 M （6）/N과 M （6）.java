import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] history;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        history = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        dfs(0,0);
        System.out.print(sb);
        
    }
    
    static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int d = 0; d < depth; d++) {
                sb.append(history[d]).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = idx; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            history[depth] = arr[i];
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
