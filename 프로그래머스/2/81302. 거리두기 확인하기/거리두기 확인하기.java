class Solution {
    static int[] dr1 = {-1,1,0,0};
    static int[] dc1 = {0,0,-1,1};
    
    static int[] dr2 = {-2,2,0,0};
    static int[] dc2 = {0,0,-2,2};
    
    static int[] dr3 = {-1,1,1,-1};
    static int[] dc3 = {1,1,-1,-1};
        
    public int[] solution(String[][] places) {
        
        int[] answer = new int[places.length];
        for (int i = 0; i < 5; i++) {
            if (isSafe(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    static boolean isSafe(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P' && !check(i,j,place)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    static boolean check(int r, int c, String[] place) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr1[i];
            int nc = c + dc1[i];
            
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
            if (place[nr].charAt(nc) == 'P') {
                return false;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr2[i];
            int nc = c + dc2[i];
            
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
            if (place[nr].charAt(nc) == 'P') {
                if (place[r + dr1[i]].charAt(c + dc1[i]) != 'X') {
                    return false;
                }
            }
        }
        
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr3[i];
            int nc = c + dc3[i];
            
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
            if (place[nr].charAt(nc) == 'P') {
                if (place[r].charAt(nc) != 'X' || place[nr].charAt(c) != 'X') {
                    return false;
                }
            }
        }
        
        return true;
    }
}