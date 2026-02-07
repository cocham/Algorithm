import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] history;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1];
        history = new int[M];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        
        dfs(1,0);
        System.out.print(sb);
    }
    
    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < depth; i++) {
                sb.append(history[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            history[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
