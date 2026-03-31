import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> inTime = new HashMap<>();
        TreeMap<String, Integer> totalTime = new TreeMap<>();
        
        for (String s : records) {
            StringTokenizer st = new StringTokenizer(s);
            String time = st.nextToken();
            String car = st.nextToken();
            String status = st.nextToken();
            
            if (status.equals("IN")) {
                String[] times = time.split(":");
                int h = Integer.parseInt(times[0]);
                int m = Integer.parseInt(times[1]);
                inTime.put(car, h * 60 + m);
            } else if (status.equals("OUT")) {
                String[] times = time.split(":");
                int h = Integer.parseInt(times[0]);
                int m = Integer.parseInt(times[1]);
                int totalT = (h * 60 + m) - inTime.get(car);
                
                totalTime.put(car, totalTime.getOrDefault(car, 0) + totalT);
                inTime.remove(car);
            }
        }
        
        for (String car : inTime.keySet()) {
            int outTime = (60 * 23 + 59) - inTime.get(car);
            totalTime.put(car, totalTime.getOrDefault(car, 0) + outTime);
        }
        
        int[] answer = new int[totalTime.size()];
        int idx = 0;
        
        for (int time : totalTime.values()) {
            if (time <= fees[0]) {
                answer[idx] = fees[1];
            } else {
                answer[idx] = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }
}