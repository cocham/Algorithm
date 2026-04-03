import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        
        int[][] minCost = new int[len + 1][m];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < m; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        minCost[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0}); //총 개수 / a흔적 / b흔적
        
        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int t = cur[0], a = cur[1], b = cur[2];
            
            if (a > minCost[t][b]) continue;
            
            if (t == len) {
                answer = Math.min(a, answer);
                continue;
            }
            
            //a가 훔치는 경우
            int aGain = a + info[t][0];
            
            if (aGain < n && aGain < minCost[t + 1][b]) {
                q.add(new int[]{t + 1, aGain, b});
                minCost[t + 1][b] = aGain;
            }
            
            //b가 훔치는 경우
            int bGain = b + info[t][1];
            
            if (bGain < m && a < minCost[t + 1][bGain]) {
                q.add(new int[]{t + 1, a, bGain});
                minCost[t + 1][bGain] = a;
            }    
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
        
    }
}