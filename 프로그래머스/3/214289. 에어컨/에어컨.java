class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        int INF = 1000 * 100; 
        int[][] dp = new int[onboard.length][51];
        for (int i = 0; i < onboard.length; i++) {
            for (int t = 0; t <= 50; t++) {
                dp[i][t] = INF;
            }
        }
        
        int startTemp = temperature + 10;
        dp[0][startTemp] = 0; //0분에 실외온도 == 실내온도 상태면 소비전력은 0
        
        for (int i = 1; i < onboard.length; i++) {
            for (int t = 0; t <= 50; t++) {
                if (onboard[i] == 1 && (t < t1 + 10 || t > t2 + 10)) continue;
                
                int minCost = INF;
                // 이전 온도: t - 1
                if (t > 0) {
                    minCost = Math.min(dp[i - 1][t - 1] + a, minCost);
                    
                    if (t - 1 < startTemp) {
                        minCost = Math.min(dp[i - 1][t - 1], minCost);
                    }
                }
                
                // 이전 온도 : t + 1
                if (t < 50) {
                    minCost = Math.min(dp[i-1][t+1] + a, minCost);
                    if (t + 1 > startTemp) {
                        minCost = Math.min(dp[i-1][t+1], minCost);
                    }
                }
                
                // 유지
                minCost = Math.min(minCost, dp[i-1][t] + b);
                
                if (t == startTemp) {
                    minCost = Math.min(minCost, dp[i-1][t]);
                }
                    
                dp[i][t] = minCost;
            }
        }
        
        int answer = INF;
        
        for (int t = 0; t <= 50; t++) {
            answer = Math.min(dp[onboard.length - 1][t], answer);
            
        }
        
        return answer;
    }
}