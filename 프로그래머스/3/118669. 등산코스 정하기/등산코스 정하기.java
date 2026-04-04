import java.util.*;

class Solution {
    static boolean[] isSummit;
    static ArrayList<int[]>[] ways;
    static int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        isSummit = new boolean[n + 1];
        for (int i = 0; i < summits.length; i++) {
            isSummit[summits[i]] = true;
        }
        
        ways  = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            ways[i] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int i = path[0], j = path[1], w = path[2];
            
            ways[i].add(new int[]{j, w});
            ways[j].add(new int[]{i, w});
        }
        
        return calc(n, gates, summits);
    }
    
    static int[] calc(int n, int[] gates, int[] summits) {
        int[] minIntense = new int[n+1];
        for (int i = 1; i <= n; i++) {
            minIntense[i] = INF;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int i : gates) {
            minIntense[i] = 0;
            pq.add(new int[]{i, 0});
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int to = cur[0];
            int w = cur[1];
            
            if (w > minIntense[to]) continue;
            if (isSummit[to]) continue;
            
            for (int[] nextTo : ways[to]) {
                int next = nextTo[0];
                int nextW = nextTo[1];
                
                // 가장 긴 시간이 가중치가 되어야 함
                int nextIntens = Math.max(w, nextW);
                
                if (nextIntens < minIntense[next]) {
                    minIntense[next] = nextIntens;
                    pq.add(new int[]{next, nextIntens});
                }
            }
        }
        
        Arrays.sort(summits);
        int summit = -1;
        int min = INF;
        for (int s : summits) {
            if (minIntense[s] < min) {
                summit = s;
                min = Math.min(min, minIntense[s]);
            }
        }
        
        return new int[]{summit, min};
    }
}