import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int W, H;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    
    static class Node {
        int r, c, time;
        char type;
        
        Node (int r, int c, int time, char type) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.type = type;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new char[H][W];
            
            Queue<Node> fireSang = new LinkedList<>();
            int sangR = -1;
            int sangC = -1;
            for (int h = 0; h < H; h++) {
                String line = br.readLine();
                for (int w = 0; w < W; w++) {
                    arr[h][w] = line.charAt(w);
                    if (arr[h][w] == '*') {
                        fireSang.add(new Node(h,w,0,'*'));
                    } else if (arr[h][w] == '@') {
                        sangR = h;
                        sangC = w;
                    }
                }
            }
            fireSang.add(new Node(sangR, sangC, 0, '@'));
            bfs(fireSang);
        }
        System.out.print(sb);
    }
    
    static void bfs(Queue<Node> fireSang) {
        while (!fireSang.isEmpty()) {
            Node cur = fireSang.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int time = cur.time;
                 
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    if (cur.type == '@') {
                        sb.append(time + 1).append('\n');
                        return; 
                    }
                    continue;
                }
                
                if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
                    if (cur.type == '*') {
                        if (arr[nr][nc] == '.' || arr[nr][nc] == '@') {
                            arr[nr][nc] = '*';
                            fireSang.add(new Node(nr, nc, time + 1, '*'));
                        }
                    } else if (cur.type == '@') {
                        if (arr[nr][nc] == '.') {
                            arr[nr][nc] = '@';
                            fireSang.add(new Node(nr, nc, time + 1, '@'));                        }
                    }
                }
            }
        }
        
        sb.append("IMPOSSIBLE").append('\n');
    }
}
