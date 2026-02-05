import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int R;
    static int C;
    static char[][] arr;
    static int[][] distF;
    static int[][] distJ;
    static Queue<Position> qF = new LinkedList<>();
    static Queue<Position> qJ = new LinkedList<>();

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
        arr = new char[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                distF[i][j] = -1;
                distJ[i][j] = -1;
                arr[i][j] = line.charAt(j);

                if (line.charAt(j) == 'J') {
                    qJ.add(new Position(i,j));
                    distJ[i][j] = 0;
                } else if (line.charAt(j) == 'F') {
                    qF.add(new Position(i,j));
                    distF[i][j] = 0;
                }
            }
        }
        
        fireBfs();
        int time = jihunBfs();
        if (time < 0) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(time);
        }
        
    }
    
    static void fireBfs() {
        while(!qF.isEmpty()) {
            Position curPos = qF.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
                    if (distF[moveX][moveY] >= 0 || arr[moveX][moveY] == '#') {
                        continue;
                    }

                    if (distF[moveX][moveY] == -1) {
                        qF.add(new Position(moveX, moveY));
                        distF[moveX][moveY] = distF[curPos.x][curPos.y] + 1; 
                    }
                }
            }
        } 
    }

    static int jihunBfs() {
        while(!qJ.isEmpty()) {
            Position curPos = qJ.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];

                if (moveX < 0 || moveX >= R || moveY < 0 || moveY >= C) {
                    return distJ[curPos.x][curPos.y] + 1;
                }

                if (distJ[moveX][moveY] >= 0 || arr[moveX][moveY] == '#') {
                    continue;
                }

                if (distF[moveX][moveY] == -1 || distJ[curPos.x][curPos.y] + 1 < distF[moveX][moveY]) {
                    qJ.add(new Position(moveX, moveY));
                    distJ[moveX][moveY] = distJ[curPos.x][curPos.y] + 1;
                }
            }
        } 

        return -1;
    }
}