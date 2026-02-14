import java.util.*;

class Solution {
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class Position {
        int r, c;
        
        Position (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        List<List<Position>> emptySpaces = new ArrayList<>();
        List<List<Position>> existSpaces = new ArrayList<>();
        boolean[][] gVisited = new boolean[N][N];
        boolean[][] tVisited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0 && !gVisited[i][j]) {
                    emptySpaces.add(bfs(game_board, gVisited,i,j,0));
                }
                if (table[i][j] == 1 && !tVisited[i][j]) {
                    existSpaces.add(bfs(table, tVisited,i,j,1));
                }
            }
        }
        
        return compare(emptySpaces, existSpaces);
    }
    
    static int compare(List<List<Position>> game, List<List<Position>> puzzles) {
        boolean[] usedPuzzle = new boolean[puzzles.size()];
        int totalFilled = 0;
        
        for (List<Position> empty : game) {
            
            for (int i = 0; i < puzzles.size(); i++) {
                if(usedPuzzle[i]) {
                    continue;
                }
                
                List<Position> puzzle = puzzles.get(i);
                if (empty.size() == puzzle.size()) {
                    if (isRotationMatch(empty, puzzle)) {
                        usedPuzzle[i] = true;
                        totalFilled += puzzle.size();
                        break;
                    }
                }
            }
        }
        
        return totalFilled;
    }
    
    static boolean isRotationMatch(List<Position> empty, List<Position> puzzle) {
        List<Position> target = normalize(empty);

        for (int i = 0; i < 4; i++) {
            puzzle = normalize(rotate(puzzle));
            
            if (isSame(target, puzzle)) {
                return true;
            }
        }
        
        return false;
    }
    
    static boolean isSame(List<Position> a, List<Position> b) {
        for (int j = 0; j < a.size(); j++) {
            Position pA = a.get(j);
            Position pB = b.get(j);

            if (pA.r != pB.r || pA.c != pB.c) {
                return false;
            }
        }
        
        return true;
    }
    static List<Position> rotate(List<Position> shape) {
        List<Position> rotated = new ArrayList<>();
        
        for (Position p : shape) {
            rotated.add(new Position(p.c, -p.r));
        }
        
        return rotated;
    }

    static List<Position> normalize(List<Position> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
    
        for (Position p : shape) {
            minR = Math.min(p.r, minR);
            minC = Math.min(p.c, minC);
        }
        
        List<Position> normalized = new ArrayList<>();
        for (Position p : shape) {
            normalized.add(new Position(p.r - minR, p.c - minC));
        }
        
        Collections.sort(normalized, (p1, p2) -> {
            if (p1.r == p2.r) return p1.c - p2.c;
            return p1.r - p2.r;
        });
            
        return normalized;
    }
    
    
    static List<Position> bfs(int[][] arr, boolean[][] visited, int row, int col, int type) {
        Queue<Position> q = new LinkedList<>();
        List<Position> part = new ArrayList<>();
        Position start = new Position(row, col);
        
        part.add(start);
        q.add(start);
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            Position cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (!visited[nr][nc] && arr[nr][nc] == type) {
                        q.add(new Position(nr,nc));
                        part.add(new Position(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return part;
        
    }
}