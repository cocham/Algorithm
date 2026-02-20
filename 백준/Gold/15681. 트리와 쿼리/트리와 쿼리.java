import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[N + 1]; 
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            tree[U].add(V);
            tree[V].add(U);
        }
        
        dfs(R, -1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            
            sb.append(size[node]).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int cur, int parent) {
        size[cur] = 1;
        
        for (int next : tree[cur]) {
            if (next == parent) continue;
            
            dfs(next, cur);
            size[cur] += size[next];
        }
    }
}