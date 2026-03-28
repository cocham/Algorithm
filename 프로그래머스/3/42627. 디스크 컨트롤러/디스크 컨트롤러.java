import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        
        int curTime = 0;
        int jobIdx = 0;
        int count = 0;
        int answer = 0;
        
        while (count < jobs.length) {
            
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= curTime) {
                pq.add(jobs[jobIdx]);
                jobIdx++;
            }
            
            if (pq.isEmpty()) {
                curTime = jobs[jobIdx][0];
            } else {
                int[] curJob = pq.poll();
                
                curTime += curJob[1];
                
                answer += curTime - curJob[0];
                
                count++;
            }
        }
        
        
        return answer / jobs.length;
    }

}