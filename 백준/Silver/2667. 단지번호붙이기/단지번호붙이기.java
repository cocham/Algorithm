import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    static int N;
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
        arr = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        
        int groupCnt = 0;
        List<Integer> houseCnts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int houseCnt = bfs(i,j);
                    groupCnt++;
                    houseCnts.add(houseCnt);
                }
            }
        }
        
        System.out.println(groupCnt);
        
        Collections.sort(houseCnts);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < houseCnts.size(); i++) {
            sb.append(houseCnts.get(i)).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int bfs(int x, int y) {
        Position pos = new Position(x,y);
        Queue<Position> q = new LinkedList<>();
        q.add(pos);
        int house = 1;
        while(!q.isEmpty()) {
            Position curPos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int moveX = curPos.x + dx[i];
                int moveY = curPos.y + dy[i];
                
                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                    if (arr[moveX][moveY] == 1 && !visited[moveX][moveY]) {
                        visited[moveX][moveY] = true;
                        q.add(new Position(moveX, moveY));
                        house++;
                    }
                }
            }
        }
        
        return house;
        
    }
}