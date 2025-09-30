import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                push(num);
            } else if (command.equals("pop")) {
                pop();
            } else if (command.equals("size")) {
                size();
            } else if (command.equals("empty")) {
                empty();
            } else if (command.equals("top")) {
                top();
            }
        }
        
        System.out.print(sb);
    }
    
    static void push(int x) {
       stack.add(x);
    }
    
    static void pop() {
        if (stack.isEmpty()) {
            sb.append(-1).append('\n');
            return;
        }
        int popped = stack.remove(stack.size() - 1);
        sb.append(popped).append('\n'); 
    }
    
    static void size() {
        sb.append(stack.size()).append('\n');
    }
    
    static void empty() {
        if (stack.isEmpty()) {
            sb.append(1).append('\n');
            return;
        }
        sb.append(0).append('\n');
    }
    
    static void top() {
        if (stack.isEmpty()) {
            sb.append(-1).append('\n');
            return;
        } else {       
            int top = stack.get(stack.size() - 1);
            sb.append(top).append('\n'); 
        }
    }
}