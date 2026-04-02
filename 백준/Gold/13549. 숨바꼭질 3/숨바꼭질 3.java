import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, K;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new int[100001];
        System.out.print(bfs());
    }
    
    static int bfs() {
        int[] minTime = new int[100001];
        for (int i = 0; i < minTime.length; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{N, 0});
        minTime[N] = 0;
        int[] direc = {-1, 1, 2};
        
        while (!q.isEmpty()) {
            int[] x = q.poll();
            int r = x[0];
            int curT = x[1];
                
            if (r == K) break;
            
            for (int i = 0; i < 3; i++) {
                int nr = r + direc[i];
                int t = 1;
                if (i == 2) {
                    nr = r * 2;
                    t = 0;
                }

                if (nr < 0 || nr > 100000) continue;
                if (curT + t < minTime[nr]) {
                    minTime[nr] = curT + t;
                    q.add(new int[]{nr, curT + t});
                }
            }
        }
        
        return minTime[K];
        
    }
}
