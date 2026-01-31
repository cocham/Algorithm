import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
    static int[] road = new int[100000 + 1];;
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        if (N == K) {
            System.out.println(0);
            return;
        }
        
        bfs(N);        
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        road[start] = 0;
        
        while (!q.isEmpty()) {
            int curPos = q.poll();
            
            int[] moves = {curPos + 1, curPos - 1, curPos * 2};
            for (int next : moves) {
                if (next >= 0 && next <= 100000) {
                    if (road[next] == 0) {
                        q.add(next);
                        road[next] = road[curPos] + 1;
                        
                        if (next == K) {
                            System.out.print(road[next]);
                            return;
                        }
                    }
                }
            }
        }
    }
}