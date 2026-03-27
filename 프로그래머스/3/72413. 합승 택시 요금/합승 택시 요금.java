import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;


class Solution {
    static class Edge {
        int to, cost;
        
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    static ArrayList<Edge>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            
            graph[c].add(new Edge(d, f));
            graph[d].add(new Edge(c, f));
        }
        
        int[] sCosts = daik(s, n);
        int[] aCosts = daik(a, n);
        int[] bCosts = daik(b, n);
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int totalCost = sCosts[i] + aCosts[i] + bCosts[i];
            answer = Math.min(answer, totalCost);
        }
        
        return answer;
    }
    
    static int[] daik(int start, int n) {
        int[] minCosts = new int[n + 1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Edge(start, 0));
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (cur.cost > minCosts[cur.to]) continue;
            
            for (Edge next : graph[cur.to]) {
                int nextCost = cur.cost + next.cost;
                
                if (nextCost < minCosts[next.to]) {
                    minCosts[next.to] = nextCost;
                    pq.add(new Edge(next.to, nextCost));
                }
            }
        }
        
        return minCosts;
    }
}