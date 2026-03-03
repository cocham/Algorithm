class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        
        int ans = 0;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                ans++;
            }
        }
        
        return ans;
    }
    
    static void dfs(int i, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (i == j) continue;
            if (visited[j]) continue;
            
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}