class Solution {
    static int min = Integer.MAX_VALUE;
    static int size;
    static int size2;
    
    public int solution(int[][] beginning, int[][] target) {
        size = target.length;
        size2 = target[0].length;
        
        dfs(0, 0, beginning, target);
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    static void dfs(int r, int fcnt, int[][] board, int[][] target) {
        if (r == board.length) {
            int flip = calcDiff(board, target);
            if (flip != -1) {
                min = Math.min(min, fcnt + flip);
            }
            
            return;
        }
        
        dfs(r + 1, fcnt, board, target);
        
        flip(r, board);
        dfs(r + 1, fcnt + 1, board, target);
        flip(r, board);
    }
    
    static int calcDiff(int[][] board, int[][] target) {
        int flip = 0;
        
        for (int j = 0; j < size2; j++) {
            int match = 0;

            for (int i = 0; i < size; i++) {
                if (board[i][j] == target[i][j]) {
                    match++;
                }
            }
            
            if (match == size) {
                continue;
            }
            
            if (match == 0) {
                flip++;
            }
            
            else {
                return -1;
            }
        }
        
        return flip;
    }
    
    static void flip(int r, int[][] board) {
        int len = board[0].length;
        
        for (int j = 0; j < len; j++) {
            if (board[r][j] == 0) {
                board[r][j] = 1;
            } else {
                board[r][j] = 0;
            }
        }
    }
}