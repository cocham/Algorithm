import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            if (order.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            } else if (order.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(stack.pop());
                }
                sb.append("\n");
            } else if (order.equals("size")) {
                sb.append(stack.size()).append('\n');
                
            } else if (order.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else {
                if (stack.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(stack.peek());
                }
                sb.append("\n");
            }
            
        }
        
        System.out.print(sb);
    }
}