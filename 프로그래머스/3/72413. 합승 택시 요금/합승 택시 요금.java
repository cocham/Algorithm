import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    static class Node {
        int to, cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {   
        ArrayList<Node>[] graph = new ArrayList[n + 1];
    
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int start = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph[start].add(new Node(to, cost));
            graph[to].add(new Node(start, cost));
        }
        
        int[] distS = daik(s, n, graph);
        int[] distA = daik(a, n, graph);
        int[] distB = daik(b, n, graph);
        
        int minFare = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) continue;
            
            minFare = Math.min(minFare, distS[i] + distA[i] + distB[i]);
        }
       
        return minFare;
    }
    
    static int[] daik(int start, int n, ArrayList<Node>[] graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.cost > dist[cur.to]) continue;
            
            for (Node next : graph[cur.to]) {
                int to = next.to;
                
                int nextCost = cur.cost + next.cost;
                
                if (nextCost < dist[to]) {
                    dist[to] = nextCost;
                    pq.add(new Node(to, nextCost));
                }
            } 
        }
        
        return dist;
    }
}