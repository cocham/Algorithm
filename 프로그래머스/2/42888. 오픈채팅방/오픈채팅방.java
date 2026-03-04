import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> userAka = new HashMap<>();
        for (String s : record) {
            String[] str = s.split(" ");
            
            String order = str[0];
            String id = str[1];            
            
            if (order.equals("Enter") || order.equals("Change")) {
                String aka = str[2];
                userAka.put(id, aka);                
            }
        }

        
        ArrayList<String> results = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            
            String order = str[0];
            String id = str[1];
            
            if (order.equals("Enter")) {
                results.add((userAka.get(id) + "님이 들어왔습니다."));
            } else if (order.equals("Leave")) {
                results.add((userAka.get(id) + "님이 나갔습니다."));
            }
            
        }
        
        String[] answer = new String[results.size()];  
        for (int i = 0; i < answer.length; i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}