import java.util.ArrayList;

class Solution {
    static ArrayList<Integer>[] tree;
    static int maxSheep;
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
        
        dfs(0, 1, 0, tree[0]);
        return maxSheep;
    }
    
    static void dfs(int node, int sheep, int wolf, ArrayList<Integer> nextNodes) {
        if (wolf >= sheep) {
            return;
        }
        
        maxSheep = Math.max(sheep, maxSheep);
        
        for (int i = 0; i < nextNodes.size(); i++) {
            int next = nextNodes.get(i); //child
            
            ArrayList<Integer> nextNext = new ArrayList<>(nextNodes);
            
            nextNext.remove(Integer.valueOf(next));
            
            nextNext.addAll(tree[next]);
            
            if (info[next] == 1) {
                dfs(next, sheep, wolf + 1, nextNext);
            } else if (info[next] == 0) {
                dfs(next, sheep + 1, wolf, nextNext);
            }
        }
    }
}