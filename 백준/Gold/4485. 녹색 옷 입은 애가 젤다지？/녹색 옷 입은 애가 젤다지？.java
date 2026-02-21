import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] arr;
    static int[][] cost; 
    static StringBuilder sb = new StringBuilder();
    
    static class Node {
        int r, c, cost;
        
        Node (int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            arr = new int[N][N];
            cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            bfs();
            sb.append("Problem ")
                .append(p).append(": ")
                .append(cost[N - 1][N - 1]).append('\n');
            p++;
        }
        
        System.out.print(sb);
    }
    
    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        
        pq.add(new Node(0,0,arr[0][0]));
        cost[0][0] = arr[0][0];
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.cost > cost[cur.r][cur.c]) continue;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (cur.cost + arr[nr][nc] < cost[nr][nc]) {
                    cost[nr][nc] = cur.cost + arr[nr][nc];
                    pq.add(new Node(nr, nc, cost[nr][nc]));
                }
            }
        }
    }
}