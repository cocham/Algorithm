import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static int gcnt = 0;
    static ArrayList<ArrayList<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
       
        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                gcnt++;
            }
        }
        
        System.out.print(gcnt);
    }
    
    static void dfs(int n) {
        visited[n] = true;
        
        for (int i : graph.get(n)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
