import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        boolean visited[] = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        
        visited[1] = true;
        q.offer(1);
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (visited[next]) {
                    continue;
                }
                
                visited[next] = true;
                q.offer(next);
                count++;
            }
        }
        
        System.out.println(count);
    }
}