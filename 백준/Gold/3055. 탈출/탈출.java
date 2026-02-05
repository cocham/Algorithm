import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int R;
    static int C;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int[][] distW;
    static int[][] distH;
    static Queue<Position> wAxis = new LinkedList<>();
    static Queue<Position> hAxis = new LinkedList<>();
    
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
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        distW = new int[R][C];
        distH = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                distW[i][j] = -1;
                distH[i][j] = -1;
                
                if (map[i][j] == '*') {
                    wAxis.add(new Position(i,j));
                    distW[i][j] = 0;
                } else if (map[i][j] == 'S') {
                    hAxis.add(new Position(i,j));
                    distH[i][j] = 0;
                } 
            }
        }
        
        waterBfs();
        int time = hedBfs();
        if (time < 0) {
            System.out.print("KAKTUS");
        } else {
            System.out.print(time);
        }
        
    }
    
    static void waterBfs() {
        while(!wAxis.isEmpty()) {
            Position curPos = wAxis.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
                    if (map[moveX][moveY] != 'X' 
                    && map[moveX][moveY] != 'D' 
                    && distW[moveX][moveY] < 0) {
                        distW[moveX][moveY] = distW[curPos.x][curPos.y] + 1;
                        wAxis.add(new Position(moveX, moveY));
                    }
                }
            }
        }
    }
    
    static int hedBfs() {
        while(!hAxis.isEmpty()) {
            Position curPos = hAxis.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];

                if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
                    if (map[moveX][moveY] == 'D') {
                        return distH[curPos.x][curPos.y] + 1;
                    }
                    
                    if (map[moveX][moveY] != '*' 
                        && map[moveX][moveY] != 'X'
                        && distH[moveX][moveY] < 0){ 
                        if (distH[curPos.x][curPos.y] + 1 < distW[moveX][moveY] || distW[moveX][moveY] == -1){
                            distH[moveX][moveY] = distH[curPos.x][curPos.y] + 1;
                            hAxis.add(new Position(moveX, moveY)); 
                        }
                    }
                }
            }
        }

    return -1;
    }
}