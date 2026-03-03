import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static String bomb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        bomb = br.readLine();
        int bombLen = bomb.length();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            stack.push(c);

            if (c == bomb.charAt(bombLen - 1)) {
                if (stack.size() < bombLen) continue;
                
                boolean isBomb = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                
                if (isBomb) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if (sb.length() == 0) {
            System.out.print("FRULA");
        } else {
            System.out.print(sb.reverse().toString());
        }
    }
}
