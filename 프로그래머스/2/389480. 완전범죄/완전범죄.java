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
        // i번째 물건
        for (int i = 1; i <= len; i++) {
            int infoA = info[i-1][0];
            int infoB = info[i-1][1];
            
            // j는 b의 누적 흔적점수
            for (int j = 0; j < m; j++) {
                
                // a를 뽑음  
                dp[i][j] = Math.min(dp[i-1][j] + infoA, dp[i][j]);
                
                // b를 뽑음
                if (j + infoB < m) {
                    dp[i][j + infoB] = Math.min(dp[i][j + infoB], dp[i-1][j]);
                }
            }
        }
        
        int answer = INF;
        for(int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[len][i]);
        }
        
        if (answer >= n) {
            return -1;
        }
        return answer;
    }
}