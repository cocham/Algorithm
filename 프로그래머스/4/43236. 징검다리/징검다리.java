import java.util.Arrays;

class Solution {
    public long solution(int distance, int[] rocks, int n) {
        long answer = 0;
        
        Arrays.sort(rocks);
        long left = 0;
        long right = distance;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            int curPos = 0;
            int removeCnt = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - curPos < mid) {
                    removeCnt++;
                } else {
                    curPos = rocks[i];
                }
            }
            
            if (distance - curPos < mid) {
                removeCnt++;
            }
            
            if (removeCnt > n) {
                right = mid - 1;
            } else {
                answer = Math.max(mid, answer);
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
}