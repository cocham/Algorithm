import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            
            q.offer(i);
            
            while (!q.isEmpty()) {
                int cur = q.poll();
                
                for (int j = 0; j < n; j++) {
                    if (graph[cur][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    } 
                }
            }
            
            for (int k = 0; k < n; k++) {
                if (visited[k]) {
                    answer[i][k] = 1;
                } else {
                    answer[i][k] = 0;
                }
                sb.append(answer[i][k]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}