import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String s;
        
        while (!(s = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isOkay = true;
            
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isOkay = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isOkay = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if (isOkay && stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
