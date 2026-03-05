import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    
    static class Node {
        int to, cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int start = r[0];
            int to = r[1];
            int cost = r[2];
            
            graph[start].add(new Node(to, cost));
            graph[to].add(new Node(start, cost));
        }

        int[] costs = daik(1, N, graph);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (costs[i] <= K) {
                cnt++;
            }
        }
        
        return cnt;
    }
    
    static int[] daik(int start, int N, ArrayList<Node>[] graph) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(1,0));
        costs[start] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for (Node next : graph[cur.to]) {
                if (cur.cost > costs[cur.to]) continue;
                
                int nextCost = cur.cost + next.cost;
                
                if (nextCost < costs[next.to]) {
                    costs[next.to] = nextCost;
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }
        
        return costs;
    }
}