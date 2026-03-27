import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    
    static class Edge {
        int to;
        int weight;
        
        Edge (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int N, M;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        bfs(start, end);
    }
    
    static void bfs(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> b.weight - a.weight);
        int[] maxWeight = new int[N + 1];
        
        pq.add(new Edge(start, Integer.MAX_VALUE));
        maxWeight[start] = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (cur.to == end) {
                System.out.println(cur.weight);
                return;
            }
            
            if (maxWeight[cur.to] > cur.weight) continue;
            
            for (Edge next : graph[cur.to]) {
                int nextWeight = Math.min(next.weight, cur.weight);
                
                if (maxWeight[next.to] < nextWeight) {
                    maxWeight[next.to] = nextWeight;
                    pq.add(new Edge(next.to, nextWeight));
                }
                
            }
        }
    }
}
