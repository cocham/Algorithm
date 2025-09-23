class Solution {
    public int solution(String s) {
        int answer = s.length();
        int length = s.length();

        for (int u = 1; u <= length / 2; u++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, u);
            int cnt = 1;
            
            int c = u;
            for (; c + u <= length; c += u) {
                String curr = s.substring(c, c + u);
                if (curr.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    prev = curr;
                    cnt = 1;
                    } 
                }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
                        
            if (c < length) {
                sb.append(s.substring(c, length));
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        
        return answer;
    }
}