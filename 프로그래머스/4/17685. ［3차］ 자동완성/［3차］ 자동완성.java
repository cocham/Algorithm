import java.util.Arrays;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        int[] counts = new int[words.length];
        
        for (int i = 0; i < words.length - 1; i++) {
            String stand = words[i];
            String comp = words[i + 1];
            
            int len = Math.min(stand.length(), comp.length());
            int matchLen = 0;
            
            for (int j = 0; j < len; j++) {
                if (stand.charAt(j) == comp.charAt(j)) {
                    matchLen++;
                } else {
                    break;
                }
            }
            
            int typeCnt = matchLen + 1;
            
            counts[i] = Math.max(counts[i], Math.min(typeCnt, stand.length()));
            counts[i + 1] = Math.max(counts[i + 1], Math.min(typeCnt, comp.length()));
        }
        
        for (int i = 0; i < counts.length; i++) {
            answer += counts[i];
        }
        return answer;
    }
}