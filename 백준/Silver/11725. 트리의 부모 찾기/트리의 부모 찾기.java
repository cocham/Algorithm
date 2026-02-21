import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] parent;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
            
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }
        
        parent[1] = 1;
        dfs(1);
        
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int cur) {
        for (int next : tree[cur]) {
            if (parent[next] != 0) continue;
            parent[next] = cur;
            dfs(next);
        }
    }
}
