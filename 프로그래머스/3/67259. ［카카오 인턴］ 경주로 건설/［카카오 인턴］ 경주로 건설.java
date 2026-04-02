import java.util.*;

class Solution {
    static int N;
    
    public int solution(int[][] board) {
        N = board.length;
        
        return bfs(board);
        
        
    }
    
    static int bfs(int[][] board) {
        int[][][] minCost = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    minCost[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[3] - b[3]);
        
        pq.add(new int[]{0,0,-1,0}); //r,c,방향,비용
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], direc = cur[2], cost = cur[3];
            if (r == N - 1 && c == N - 1) {
                return cost;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 1) continue;
                
                int nextCost = cost;
                
                if (direc == -1 || d == direc) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }

                if (nextCost < minCost[nr][nc][d]) {
                    minCost[nr][nc][d] = nextCost;
                    pq.add(new int[]{nr, nc, d, nextCost});
                }
            }
        }
        

        return -1;
    }
}