class Solution {
    static boolean[] visited;
    static int maxCnt = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        return maxCnt;
    }
    
    static void dfs(int stamina, int cnt, int[][] dungeons) {
        maxCnt = Math.max(cnt, maxCnt);
            
        for (int i = 0; i < dungeons.length; i++) {
            
            int gage = dungeons[i][0];
            int minus = dungeons[i][1];
            
            if (stamina >= gage && !visited[i]) {
                visited[i] = true;
                dfs(stamina - minus, cnt + 1, dungeons);
                visited[i] = false;
            }
            
        }
    }
    
}