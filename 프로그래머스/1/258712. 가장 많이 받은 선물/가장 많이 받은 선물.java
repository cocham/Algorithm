import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        final int fNum = friends.length;
        
        Map<String, Integer> findex = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            findex.put(friends[i], i);
        }
        
        int[][] count = new int[fNum][fNum];
        int[] give = new int[fNum];
        int[] take = new int[fNum];
        
        for (String g : gifts) {
            String[] sp = g.split(" ");
            int giver = findex.get(sp[0]);
            int taker = findex.get(sp[1]);
            count[giver][taker]++;
            give[giver]++;
            take[taker]++;
        }
        
        int[] nextMonth = new int[fNum];
        for (int i = 0; i < fNum; i++) {
            for (int j = i + 1; j < fNum; j++) {
                if (count[i][j] > count[j][i]) {
                    nextMonth[i]++;
                } else if (count[i][j] < count[j][i]) {
                    nextMonth[j]++;
                } else {
                    int icount = give[i] - take[i];
                    int jcount = give[j] - take[j];
                    if (icount > jcount) {
                        nextMonth[i]++;
                    } else if (jcount > icount) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int v : nextMonth) {
            if (v > answer) {
                answer = v;
            }
        }
        
        return answer;
    }
}