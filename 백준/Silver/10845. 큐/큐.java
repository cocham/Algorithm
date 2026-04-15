import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            if (order.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                q.add(n);
            } else if (order.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.poll());
                }
                sb.append("\n");
            } else if (order.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if (order.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else if (order.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.peek());
                }
                sb.append("\n");
            } else if (order.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(q.peekLast());
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
