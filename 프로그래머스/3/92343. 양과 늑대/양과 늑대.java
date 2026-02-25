import java.util.ArrayList;
import java.util.List;

class Solution {
    static ArrayList<Integer>[] tree;
    static int maxSheep = 0;
    static int[] info;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int root = edges[i][0];
            int child = edges[i][1];
            tree[root].add(child);
        }
        
        dfs(0,1,0,tree[0]);
        return maxSheep;
    }
    
    void dfs(int cur, int sheep, int wolf, List<Integer> nextNodes) {
        
        if (wolf >= sheep) {
            return;
        }
        
        maxSheep = Math.max(maxSheep, sheep);
        
        for (int i = 0; i < nextNodes.size(); i++) {
            int next = nextNodes.get(i);

            List<Integer> copy = new ArrayList<>();
            for (int j = 0; j < nextNodes.size(); j++) {
                if (i == j) continue;
                copy.add(nextNodes.get(j));
            }
            
            for (int child: tree[next]) {
                copy.add(child);
            }
            
            if (info[next] == 0) {
                dfs(next, sheep + 1, wolf, copy);
            } else if (info[next] == 1) {
                dfs(next, sheep, wolf + 1, copy);
            }
            
        }
        
        
    }
}