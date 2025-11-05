import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }
        
        while (dq.size() > 1) {
            int fst = dq.poll();
            
            int deadSize = Math.min(dq.size(), k - 1);
            for (int i = 0; i < deadSize; i++) {
                dq.poll();
            }            
            
            if (!dq.isEmpty()) {
                dq.addLast(fst);
            } else {
                dq.addFirst(fst);
            }
        }
        
        System.out.print(dq.peekFirst());
    }
}