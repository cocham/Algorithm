import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] tree;
    static int minDiff = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int to = wires[i][1];
            
            tree[s].add(to);
            tree[to].add(s);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            ArrayList<Integer> agroup = tree[a];
            ArrayList<Integer> bgroup = tree[b];
            
            agroup.remove(Integer.valueOf(b));
            bgroup.remove(Integer.valueOf(a));
            
            int acnt = bfs(a,n);
            int bcnt = bfs(b,n);
            
            agroup.add(b);
            bgroup.add(a);
            minDiff = Math.min(Math.abs(acnt - bcnt), minDiff);
        }
        
        return minDiff;
    }
    
    static int bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(start);
        visited[start] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int num : tree[cur]) {
                if (visited[num]) continue;
                visited[num] = true;
                q.add(num);
                cnt++;
            }
        }
        
        return cnt;
    }
    
}