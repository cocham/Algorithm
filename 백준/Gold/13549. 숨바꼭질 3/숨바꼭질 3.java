import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        pq.add(new int[]{N, 0});
        minTime[N] = 0;
        int[] direc = {-1, 1, 2};
        
        while (!pq.isEmpty()) {
            int[] x = pq.poll();
            int r = x[0];
            int curT = x[1];
                            
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
                    pq.add(new int[]{nr, curT + t});
                }
            }
        }
        
        return minTime[K];
        
    }
}
