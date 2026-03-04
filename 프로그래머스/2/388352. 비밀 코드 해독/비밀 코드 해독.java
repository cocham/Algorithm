class Solution {
    static int[] selected;
    static int cnt;
    
    public int solution(int n, int[][] q, int[] ans) {
        selected = new int[5];
        dfs(1, 0, n, q, ans);
        return cnt;
    }
    
    static void dfs(int pick, int depth, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isValid(selected, q, ans)) {
                cnt++;
            }
            
            return;
        }
        
        for (int i = pick; i <= n; i++) {
            selected[depth] = i;

            dfs(i + 1, depth + 1, n, q, ans);
        }
    }
    
    static boolean isValid(int[] pick, int[][] q, int[] ans) {
        
        for (int i = 0; i < q.length; i++) {
            int sameCnt = ans[i];
            int cnt = 0;
            
            for (int j = 0; j < q[i].length; j++) {
                for (int k = 0; k < pick.length; k++) {
                    if (q[i][j] == pick[k]) {
                        cnt++;
                    }
                }
            }
            
            if (cnt != sameCnt) {
                return false;
            }
        }
        
        return true;
    }
}