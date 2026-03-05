import java.util.PriorityQueue;

class Solution {
    static int[] mento;
    static int minTime = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        
        mento = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            mento[i] = 1;
        }
        
        int remain = n - k;
        
        dfs(1, remain, k, reqs);
        
        return minTime;
    }
    
    static void dfs(int type, int remain, int k, int[][] reqs) {
        if (type > k) {
            if (remain == 0) {
                calc(reqs, k);
            }
            return;
        }
        
        for (int i = 0; i <= remain; i++) {
            mento[type] += i;
            dfs(type + 1, remain - i, k, reqs);
            mento[type] -= i;
        }
    }
    
    static void calc(int[][] reqs, int k) {
        int totalWait = 0;
        
        for (int type = 1; type <= k; type++) {
        
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int[] req: reqs) {
                int start = req[0];
                int duration = req[1];
                int reqType = req[2];

                if (reqType != type) continue;
                
                if (pq.size() < mento[type]) {
                    pq.add(start + duration);
                } else {
                    int firstFinish = pq.poll();
                    
                    if (firstFinish <= start) {
                        pq.add(start + duration);
                    } else {
                        totalWait += (firstFinish - start);
                        pq.add(firstFinish + duration);
                    }                    
                }
            }
        }
        
        minTime = Math.min(totalWait, minTime);
    }
}