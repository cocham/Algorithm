import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        
        System.out.print(sb);
    }
    
    static void dfs(int depth) {
        if (depth == M) {
            for (int d = 0; d < depth; d++) {
                sb.append(result[d]).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                prev = arr[i];
                result[depth] = arr[i];

                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}