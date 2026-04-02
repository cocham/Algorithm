import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        alp = Math.min(maxAlp, alp);
        cop = Math.min(maxCop, cop);
        
        //알고력과 코딩력이 좌표임. 해당 좌표의 최소시간을 구하는 것.
        int[][] minTime = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{alp, cop, 0}); //알고력,코딩력,시간
        minTime[alp][cop] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int calp = cur[0];
            int ccop = cur[1];
            int ctime = cur[2];
            
            if (ctime > minTime[calp][ccop]) continue;
            
            // 최소시간에 도달할 수 있는 방법은 알고력을 높이거나 코딩력을 높이거나 문제를 푸는 것임
            // 알고리즘 공부
            // 다음 알고리즘 공부량이 max값을 넘길 필요는 없음
            int nalp = Math.min(calp + 1, maxAlp);
            if (ctime + 1 < minTime[nalp][ccop]) {
                minTime[nalp][ccop] = ctime + 1;
                q.add(new int[]{nalp, ccop, ctime + 1});
            }
            
            // 코딩공부
            int ncop = Math.min(ccop + 1, maxCop);
            if (ctime + 1 < minTime[calp][ncop]) {
                minTime[calp][ccop] = ctime + 1;
                q.add(new int[]{calp, ncop, ctime + 1});
            }
            
            // 문제풀기
            for (int[] p : problems) {
                int reqa = p[0], reqc = p[1];
                int rea = p[2], rec = p[3];
                int time = p[4];
                
                //풀 수 있다면
                if (reqa <= calp && reqc <= ccop) {
                    //max값 이상의 능력치는 필요없음
                    int nextGainA = Math.min(calp + rea, maxAlp);
                    int nextGainC = Math.min(ccop + rec, maxCop);
                    if(ctime + time < minTime[nextGainA][nextGainC] ) {
                        q.add(new int[]{nextGainA, nextGainC, ctime + time});
                        minTime[nextGainA][nextGainC] = ctime + time;
                    }
                    
                }
            }
        }
        
        return minTime[maxAlp][maxCop];
        
    }
    
}