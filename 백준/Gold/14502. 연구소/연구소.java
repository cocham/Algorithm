import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] tempArr;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Position> blanks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    blanks.add(new Position(i, j));
                }
            }
        }
        
        int maxCnt = 0;
        for (int i = 0; i < blanks.size(); i++) {
            for (int j = i + 1; j < blanks.size(); j++) {
                for (int k = j + 1; k < blanks.size(); k++) {
                    Position wall1 = blanks.get(i);
                    Position wall2 = blanks.get(j);
                    Position wall3 = blanks.get(k);
                    
                    arr[wall1.x][wall1.y] = 1;
                    arr[wall2.x][wall2.y] = 1;
                    arr[wall3.x][wall3.y] = 1;
                    
                    virusBfs();
                    maxCnt = Math.max(cntSafeZone(), maxCnt);
                    visited = new boolean[N][M];
                    
                    arr[wall1.x][wall1.y] = 0;
                    arr[wall2.x][wall2.y] = 0;
                    arr[wall3.x][wall3.y] = 0;
                } 
            }
        } 

        System.out.print(maxCnt);
        
    }
    
    static void virusBfs() {
        Queue<Position> q = new LinkedList<>();
        tempArr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArr[i][j] = arr[i][j];
                
                if (tempArr[i][j] == 2) {
                    q.add(new Position(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                    if (!visited[moveX][moveY] && tempArr[moveX][moveY] == 0) {
                        tempArr[moveX][moveY] = 2;
                        visited[moveX][moveY] = true;
                        q.add(new Position(moveX, moveY));
                    }
                }
            }
        }
    }
    
    static int cntSafeZone() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempArr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}