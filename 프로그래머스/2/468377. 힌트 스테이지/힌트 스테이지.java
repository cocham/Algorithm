class Solution {
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        dfs(0, 0, new int[cost.length], cost, hint);
        return answer;
    }
    
    static void dfs(int stage, int pay, int[] myHint, int[][] cost, int[][] hint) {
        
        if (stage == cost.length) {
            answer = Math.min(answer, pay);
            return;
        }
        
        int maxUsable = cost[stage].length - 1;
        int hintCount = Math.min(myHint[stage], maxUsable);
        
        int baseCost = cost[stage][hintCount];
        
        dfs(stage + 1, pay + baseCost, myHint, cost, hint);
        
        if (stage < hint.length) {
            int bundleCost = hint[stage][0];
            
            int[] nextHint = myHint.clone();
            
            for (int i = 1; i < hint[stage].length; i++) {
                int target = hint[stage][i] - 1;
                nextHint[target]++;
            }
            
            dfs(stage + 1, pay + baseCost + bundleCost, nextHint, cost, hint);
        }
    }
}