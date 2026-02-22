import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            sb.append((M + 1) / 2).append('\n');
            PriorityQueue<Integer> leftQ = new PriorityQueue<>((Collections.reverseOrder()));
            PriorityQueue<Integer> rightQ = new PriorityQueue<>();
            
            for (int i = 0; i < M; i++) {
                if (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                
                int n = Integer.parseInt(st.nextToken());
                
                if (leftQ.size() == rightQ.size()) {
                    leftQ.add(n);
                } else {
                    rightQ.add(n);
                }
                
                if (!rightQ.isEmpty() && leftQ.peek() > rightQ.peek()) {
                    int r = rightQ.poll();
                    int l = leftQ.poll();
                    leftQ.add(r);
                    rightQ.add(l);
                }
                
                if (i % 2 == 0) {
                    sb.append(leftQ.peek()).append(" ");
                    cnt++;
                    
                    if (cnt % 10 == 0) {
                        sb.append('\n');
                    }
                }
            }
             
            if (cnt % 10 != 0) {
                sb.append('\n');
            }
        }
        
        System.out.print(sb);
    }
}
