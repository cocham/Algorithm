import java.util.ArrayList;

class Solution {
    static int n;
    static int minDiff;
    static ArrayList<Integer>[] tree;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        this.n = n;
        minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int root = wires[i][0];
            int child = wires[i][1];
            
            tree[root].add(child);
            tree[child].add(root);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            tree[a].remove(Integer.valueOf(b));
            tree[b].remove(Integer.valueOf(a));
            
            boolean[] visited = new boolean[n + 1];
            
            int aGroup = dfs(a, visited);
            int bGroup = n - aGroup;
            
            tree[a].add(b);
            tree[b].add(a);
            
            int diff = Math.abs(aGroup - bGroup);
            minDiff = Math.min(diff, minDiff);
        }
        
        return minDiff;
    }
    
    static int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;
        
        for (int n : tree[node]) {
            if (!visited[n]) {
                cnt += dfs(n, visited);
            }
        }
        
        return cnt;
    }
}