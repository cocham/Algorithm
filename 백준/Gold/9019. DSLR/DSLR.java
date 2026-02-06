import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int A;
    static int B;
    static int[] history;
    static char[] orderHistory;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            history = new int[10000];
            orderHistory = new char[10000];
            bfs(A,B);
        }
        
        System.out.print(sb);
    }
    
    static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int n = q.poll();
            
            if (n == target) {
                StringBuilder part = new StringBuilder();
                int idx = n;
                while (idx != A) {
                    part.append(orderHistory[idx]);
                    idx = history[idx];
                }
                
                sb.append(part.reverse().toString()).append('\n');
                return;
            }
            
            int nextD = (n * 2) % 10000;
            if (!visited[nextD]) {
                visited[nextD] = true;
                history[nextD] = n;
                orderHistory[nextD] = 'D';
                q.add(nextD);
            }
            int nextS = (n == 0) ? 9999 : n - 1;
            if (!visited[nextS]) {
                visited[nextS] = true;
                history[nextS] = n;
                orderHistory[nextS] = 'S';
                q.add(nextS);
            }            
            int nextL = (n % 1000 * 10) + (n / 1000);
            if (!visited[nextL]) {
                visited[nextL] = true;
                history[nextL] = n;
                orderHistory[nextL] = 'L';
                q.add(nextL);
            }  
            int nextR = (n % 10 * 1000) + (n / 10);
            if (!visited[nextR]) {
                visited[nextR] = true;
                history[nextR] = n;
                orderHistory[nextR] = 'R';
                q.add(nextR);
            }  

        }
    }
}