class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int INF = 100000;
        int time = onboard.length;
        int[][] dp = new int[time][51]; //값 = 최소 소비 전력량
        for (int i = 0; i < time; i++) {
            for (int j = 0; j <= 50; j++) {
                dp[i][j] = INF;
            }
        }
        
        int outTemp = temperature + 10;
        dp[0][outTemp] = 0;
        
        t1 += 10;
        t2 += 10;
        
        for (int i = 1; i < time; i++) {
            for (int t = 0; t <= 50; t++) {
                if (onboard[i] == 1 && (t < t1 || t > t2)) continue; //승객이 탑승 중에는 항상 쾌적해야됨
                
                int minPower = INF;
                
                // 온도 상승
                if (t - 1 >= 0) {
                    // 에어컨 OFF
                    if (t - 1 < outTemp) {
                        minPower = Math.min(dp[i - 1][t - 1], minPower);
                    }
                    
                    // 에어컨 ON
                    minPower = Math.min(dp[i - 1][t - 1] + a, minPower);
                }
                
                // 온도 하강
                if (t + 1 <= 50) {
                    // 에어컨 OFF
                    if (t + 1 > outTemp) {
                        minPower = Math.min(dp[i - 1][t + 1], minPower);
                    }
                    // 에어컨 ON
                    minPower = Math.min(dp[i - 1][t + 1] + a, minPower);
                }
                
                // 온도 유지
                // 에어컨 OFF
                if (t == outTemp) {
                    minPower = Math.min(dp[i-1][t], minPower);
                }
                
                minPower = Math.min(dp[i-1][t] + b, minPower);
                
                dp[i][t] = minPower;
            }
        }
        
        int answer = INF;
        for (int t = 0; t <= 50; t++) {
            answer = Math.min(dp[time - 1][t], answer);
        }
        
        return answer;
    }
}