class Solution {
    static char[] alphas = {'A', 'E', 'I', 'O', 'U'};
    static int cnt;
    static int answer;
    
    public int solution(String word) {
        dfs(word, "");
        return answer;
    }
    
    static void dfs (String word, String make) {
        if (make.equals(word)) {
            answer = cnt;
            return;
        }
        
        if (make.length() == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            cnt++;
            dfs(word, make + alphas[i]);
        }
    }
}