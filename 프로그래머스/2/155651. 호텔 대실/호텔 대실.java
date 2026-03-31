import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    public int solution(String[][] book_time) {
        
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            int stime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int etime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
            
            times[i][0] = stime;
            times[i][1] = etime;
        }
        
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] time : times) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();  
            }
            pq.add(time[1]);
        }
        
        return pq.size();
    }
}