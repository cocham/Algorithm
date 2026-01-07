import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static int[][] arr;
    static int n, m, v;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        
        dfs(v);
        sb.append('\n');
        check = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    
    }
    
    static void dfs(int node) {
        check[node] = true;
        sb.append(node).append(" ");
        
        for (int i = 1; i <= n; i++) {
            if (arr[node][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
    
    static void bfs(int node) {
        Deque<Integer> adj = new ArrayDeque<>();
        adj.add(node);
        check[node] = true;
        
        while (!adj.isEmpty()) {
            int cur = adj.poll();
            
            sb.append(cur).append(" ");
            for (int i = 1; i <= n; i++) {
                if (arr[cur][i] == 1 && !check[i]) {
                    adj.add(i);
                    check[i] = true;
                }
            }
        }
    }
}