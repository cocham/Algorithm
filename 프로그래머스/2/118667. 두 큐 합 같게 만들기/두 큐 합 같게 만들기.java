import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        long baseSum = 0;
        for (int i = 0; i < queue1.length; i++) {
            baseSum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            baseSum += queue2[i];
        }
        
        if (baseSum % 2 != 0) {
            return -1;
        }
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
        }
        
        long midSum = baseSum / 2;

        int cnt = 0;
        int limit = Math.max(queue1.length, queue2.length) * 4;
        while (true) {
            if (sum1 == midSum) break;
            if (cnt > limit) {
                cnt = -1;
                break;
            } 
            
            if (sum1 > midSum) {
                int pop = q1.poll();
                q2.add(pop);
                sum1 -= pop;
            } else if (sum1 < midSum) {
                int pop = q2.poll();
                q1.add(pop);
                sum1 += pop;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}