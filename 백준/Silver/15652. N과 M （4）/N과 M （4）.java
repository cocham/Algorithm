import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        pick = new int[m];
        
        dfs(0, 1);
        
        System.out.print(sb);
    }
    
    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(pick[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for (int x = start; x <= n; x++) {
            pick[depth] = x;
            dfs(depth + 1, x);
        }
    }      
}