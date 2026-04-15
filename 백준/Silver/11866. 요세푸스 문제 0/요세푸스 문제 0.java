import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!dq.isEmpty()) {

            for (int i = 1; i <= K - 1; i++) {
                dq.addLast(dq.poll());
            }    
            
            int n = dq.poll();
            if (!dq.isEmpty()) {
                sb.append(n + ", ");
            } else {
                sb.append(n + ">");
            }
        }
        
        
        System.out.print(sb);
    }
}
