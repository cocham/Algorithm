import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    
    static class Group implements Comparable<Group> {
        int r, c, totalSize, rainbowSize;
        ArrayList<int[]> list;
        
        Group (int r, int c, int totalSize, int rainbowSize, ArrayList<int[]> list) {
            this.r = r;
            this.c = c;
            this.totalSize = totalSize;
            this.rainbowSize = rainbowSize;
            this.list = list;
        }
        
        @Override
        public int compareTo (Group o) {
            if (this.totalSize != o.totalSize) {
                return o.totalSize - this.totalSize;
            }
            if (this.rainbowSize != o.rainbowSize) {
                return o.rainbowSize - this.rainbowSize;
            }
            if (this.r != o.r) {
                return o.r - this.r;
            }
            return o.c - this.c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int totalScore = 0;
        while (true) {
            visited = new boolean[N][N];
            ArrayList<Group> groups = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > 0 && !visited[i][j]) {
                        Group g = bfs(i, j);
                        if (g.totalSize >= 2) {
                            groups.add(g);
                        }
                    }
                }
            }
            
            if (groups.isEmpty()) break;
            Collections.sort(groups);
            Group target = groups.get(0);
            
            totalScore += target.totalSize * target.totalSize;
            for (int[] pos : target.list) {
                arr[pos[0]][pos[1]] = -2;
            };
            
            applyGravity();
            rotate();
            applyGravity();
        }
        
        System.out.print(totalScore);
    }
    
    static void rotate() {
        int[][] temp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N - j - 1][i] = arr[i][j];
            }
        }
        
        arr = temp;
    }
    
    static void applyGravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i][j] < 0) continue;
                
                int r = i;
                while (r + 1 < N && arr[r + 1][j] == -2) {
                    arr[r + 1][j] = arr[r][j];
                    arr[r][j] = -2;
                    r++;
                }
            }
        }
    }
    
    static Group bfs(int i, int j) {
        boolean[][] thisVisited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        thisVisited[i][j] = true;
        int startColor = arr[i][j];
        
        int total = 0;
        int rainbow = 0;
        ArrayList<int[]> list = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            list.add(cur);
            total++;
            int r = cur[0];
            int c = cur[1];
            if (arr[r][c] == 0) rainbow++;
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (thisVisited[nr][nc] || arr[nr][nc] == -1) continue;
                
                if (startColor == arr[nr][nc] || arr[nr][nc] == 0) {
                    if (arr[nr][nc] > 0) {
                        visited[nr][nc] = true;
                    }
                    thisVisited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        return new Group(i, j, total, rainbow, list);
    }
}