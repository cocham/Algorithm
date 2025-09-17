import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> personal =
            new HashMap<>(Map.of("RT", 0, "CF", 0, "JM", 0, "AN", 0));

        int[] score = {-3, -2, -1, 0, 1, 2, 3}; 
        
        for (int i = 0; i < survey.length; i++) {
            String pair = survey[i];                 
            int val = score[choices[i] - 1];        

            if (personal.containsKey(pair)) {        
                personal.put(pair, personal.get(pair) + val);
            } else {                                
                String rev = new StringBuilder(pair).reverse().toString(); 
                personal.put(rev, personal.get(rev) - val);
            }
        }
        
        String[] pairs = {"RT", "CF", "JM", "AN"};
        for (String pair : pairs) {
            int value = personal.get(pair);
            
            if (value > 0) {
                sb.append(pair.charAt(1));
            } else if (value <= 0) {
                sb.append(pair.charAt(0));
            }
        }
        
        return sb.toString();
    }
}