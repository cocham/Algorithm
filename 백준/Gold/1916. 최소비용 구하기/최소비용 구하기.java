import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static int N, M;
    
    static class Node {
        int to, cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost; 
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph[start].add(new Node(to, cost));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int minCosts = daik(S, E, graph);
        System.out.print(minCosts);
    }
    
    static int daik(int S, int E, ArrayList<Node>[] graph) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        q.add(new Node(S, 0));
        costs[S] = 0;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.to == E) {
                return costs[cur.to];
            }
            if (cur.cost > costs[cur.to]) continue;
              
            for(Node next : graph[cur.to]) {
                int nextCost = cur.cost + next.cost;
                
                if (nextCost < costs[next.to]) {
                    costs[next.to] = nextCost;
                    q.add(new Node(next.to, nextCost));
                }
            }
        }
        
        return 0;
    }
}
