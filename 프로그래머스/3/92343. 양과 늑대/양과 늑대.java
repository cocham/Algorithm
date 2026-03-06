import java.util.ArrayList;

class Solution {
    static int maxSheep;
    static ArrayList<Integer>[] tree;
    
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int root = edges[i][0];
            int child = edges[i][1];
            
            tree[root].add(child);
        }
        
        dfs(1, 0, info, tree[0]);
        return maxSheep;
        
    }
    
    static void dfs(int sheep, int wolf, int[] info, ArrayList<Integer> childs) {
        if (wolf >= sheep) {
            return;
        }
        
        maxSheep = Math.max(sheep, maxSheep);
        
        for (int i = 0; i < childs.size(); i++) {
            int nomi = childs.get(i);
            
            ArrayList<Integer> nextChilds = new ArrayList<>(childs);
            
            nextChilds.remove(i);
            
            nextChilds.addAll(tree[nomi]);
            
            if (info[nomi] == 0) {
                dfs(sheep + 1, wolf, info, nextChilds);
            } else {
                dfs(sheep, wolf + 1, info, nextChilds);
            }
        }
        
        
    }
}