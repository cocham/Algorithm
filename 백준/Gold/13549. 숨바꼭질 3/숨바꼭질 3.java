import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int limit = 100000;
    static int N;
    static int K;
    static int[] time = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(time, -1);
        bfs(N, K);
        System.out.print(time[K]);
    }
    
    static void bfs(int start, int target) {
        Deque<Integer> q = new ArrayDeque<>();
        time[start] = 0;
        q.add(start);
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            if (num == target) {
                return;
            }
            
            int step3 = num * 2;
            int step1 = num - 1;
            int step2 = num + 1;
            
            if (step3 >= 0 && step3 <= limit && time[step3] == -1) {
                time[step3] = time[num];
                q.addFirst(step3);
            }
            if (step1 >= 0 && step1 <= limit && time[step1] == -1) {
                time[step1] = time[num] + 1;
                q.addLast(step1);
            } 
            if (step2 >= 0 && step2 <= limit && time[step2] == -1) {
                time[step2] = time[num] + 1;
                q.addLast(step2);
            }
        }
    }
}
