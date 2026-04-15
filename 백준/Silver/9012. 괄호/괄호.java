import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            boolean isTrue = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isTrue = false;
                        break;
                    }
                    
                    stack.pop();
                }
            }
            
            if (stack.isEmpty() && isTrue) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
}