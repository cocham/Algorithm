class Solution {
    static boolean[] selected;
    static int result;
    
    public int solution(int n, int[][] q, int[] ans) {
        result = 0;
        selected = new boolean[n + 1];
        dfs(q, ans,  1, n, 0);
        return result;
    }
    
    static void dfs(int[][] q, int[] ans, int start, int n, int cnt) {
        if (cnt == 5) {
            check(q, ans, n);
            return;
        }
        
        for (int i = start; i <= n; i++) {
            selected[i] = true;
            dfs(q, ans, i + 1, n, cnt + 1);
            selected[i] = false;
        }
    }
    
    static void check(int[][] q, int[] ans, int n) {
        
        for (int i = 0; i < q.length; i++) {
            int correct = ans[i];
            int curCorrec = 0;
            
            for (int j = 0; j < q[i].length; j++) {
                if (selected[q[i][j]]) {
                    curCorrec++;
                }
            }
            
            if (curCorrec != correct) {
                return;
            }
        }
        
        result++;
    }
}