import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    
    static class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        
        int normalGroupCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    normalBfs(i,j);
                    normalGroupCnt++;
                }
            }
        }
        
        visited = new boolean[N][N];
        int unNormalGroupCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    unnormalBfs(i,j);
                    unNormalGroupCnt++;
                }
            }
        }
        
        System.out.print(normalGroupCnt + " " + unNormalGroupCnt);
    }
    
    static void normalBfs(int x, int y) {
        Position pos = new Position(x,y);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                    if (!visited[moveX][moveY] && arr[curPos.x][curPos.y] == arr[moveX][moveY]) {
                        q.add(new Position(moveX, moveY));
                        visited[moveX][moveY] = true;
                    }
                }
            }  
        }
    }
    
    static void unnormalBfs(int x, int y) {
        Position pos = new Position(x,y);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                    if (!visited[moveX][moveY] && 
                        (arr[curPos.x][curPos.y] == arr[moveX][moveY] || 
                       arr[curPos.x][curPos.y] == 'G' && arr[moveX][moveY] == 'R' ||
                       arr[curPos.x][curPos.y] == 'R' && arr[moveX][moveY] == 'G')) {
                        q.add(new Position(moveX, moveY));
                        visited[moveX][moveY] = true;
                    }
                }
            }  
        }
    }
}