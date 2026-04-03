class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[n][2]; 
    
        dp[0][0] = sequence[0]; // 1,-1,1,-1
        dp[0][1] = -sequence[0]; // -1,1,-1,1
        
        long max = Math.max(dp[0][0], dp[0][1]);
        
        for (int i = 1; i < n; i++) {
            long p1 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            long p2 = (i % 2 == 0) ? -sequence[i] : sequence[i];
            
            dp[i][0] = Math.max(dp[i-1][0] + p1, p1);
            dp[i][1] = Math.max(dp[i-1][1] + p2, p2);
            
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        
        return max;
    }
}