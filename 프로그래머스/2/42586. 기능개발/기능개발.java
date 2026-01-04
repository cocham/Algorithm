import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> ans = new ArrayList<>();
        
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = calc(progresses[i], speeds[i]); 
            q.addLast(day);
        }
        
        while (q.size() > 0) {
            int task = q.poll();
            int cnt = 1;
            
            while (q.size() > 0 && q.peek() <= task) {
                q.poll();
                cnt++;
            }
            
            ans.add(cnt);
        }
        
        return ans.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    
    public int calc(int p, int s) {
        int rest = 100 - p;
        int remain = rest % s;
        
        if (rest % s == 0) {
            return rest / s;
        }
        
        return rest / s + 1;
    }
}