class Solution {
    public int solution(int[][] info, int n, int m) {
                    
        int len = info.length;
        int INF = 100000;
        
        int[][] dp = new int[len + 1][m];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = INF;
            }
        }
        
        dp[0][0] = 0;
        
        for (int i = 1; i <= len; i++) {
            int aPick = info[i - 1][0];
            int bPick = info[i - 1][1];
            
            for (int b = 0; b < m; b++) {                
                dp[i][b] = Math.min(dp[i][b], dp[i - 1][b] + aPick);
                if (b + bPick < m) {
                    dp[i][b + bPick] = Math.min(dp[i][b + bPick], dp[i - 1][b]);
                }
                
            }
        }
        
        int min = INF;
        for (int b = 0; b < m; b++) {
            min = Math.min(dp[len][b], min);
        }
        
        
        if (min >= n) {
            return -1;
        }
        return min;
    }
}