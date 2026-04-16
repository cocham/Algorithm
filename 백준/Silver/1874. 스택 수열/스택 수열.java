import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        int p = 1;
        
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            
            
            while (p <= target) {
                stack.push(p);
                p++;
                sb.append("+\n");
            }
            
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            }
            
            else {
                System.out.print("NO");
                return;
            }
        }
        
        System.out.print(sb);
    }
}
