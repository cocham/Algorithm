import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<int[]> emptyBoard = new ArrayList<>();
    
    
    public int solution(int[][] game_board, int[][] table) {        
        int n = game_board.length;
        
        List<List<int[]>> emptySpaces = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();
        boolean[][] tvisited = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    emptySpaces.add(bfs(game_board, i , j, n, 0, visited));
                }
                
                if (table[i][j] == 1 && !tvisited[i][j]) {
                    pieces.add(bfs(table, i, j, n, 1, tvisited));
                }
            }
        }
        
        for (List<int[]> em : emptySpaces) {
            normalize(em);
        }
        
        for (List<int[]> p : pieces) {
            normalize(p);
        }
        
        int answer = compare(emptySpaces, pieces);
        return answer;
    }
    
    //매칭
    static int compare(List<List<int[]>> emptySpaces, List<List<int[]>> pieces) {
        boolean[] used = new boolean[pieces.size()];
        int fill = 0;
        
        for (List<int[]> empty : emptySpaces) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                
                List<int[]> piece = pieces.get(i);
                if (piece.size() != empty.size()) continue;
                
                boolean isMatched = false;
                for (int d = 0; d < 4; d++) {
                    if (isMatch(empty, piece)) {
                        isMatched = true;
                        break;
                    }
                    rotate(piece);
                }
                
                if (isMatched) {
                    used[i] = true;
                    fill += piece.size();
                    break;
                }
            }
        }
        
        return fill;
    }
    
    static boolean isMatch(List<int[]> empty, List<int[]> pieces) {
        for (int i = 0; i < empty.size(); i++) {
            if (empty.get(i)[0] != pieces.get(i)[0] || empty.get(i)[1] != pieces.get(i)[1]) {
                return false;
            }
        }
        
        return true;
    }
    
    //좌표 정규화    
    static List<int[]> normalize(List<int[]> block) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for (int[] p : block) {
            minR = Math.min(p[0], minR);
            minC = Math.min(p[1], minC);
        }
        
        for (int[] p : block) {
            p[0] -= minR;
            p[1] -= minC;
        }
        
        Collections.sort(block, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        return block;
    }
    
    // 회전
    static void rotate(List<int[]> block) {
        for (int[] p : block) {
            int temp = p[0];
            p[0] = p[1];
            p[1] = -temp;            
        }
        
        normalize(block);
    }
    
    // 덩어리 분리
    static List<int[]> bfs(int[][] board, int i, int j, int n, int target, boolean[][] visited) {
        List<int[]> group = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i, j});
        group.add(new int[]{i, j});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != target) continue;
                
                group.add(new int[]{nr, nc});
                visited[nr][nc] = true;  
                q.add(new int[]{nr, nc});
            }
        }
        
        return group;
    }
    
}