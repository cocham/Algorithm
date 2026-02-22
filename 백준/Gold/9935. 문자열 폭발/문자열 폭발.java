import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class Main {
    static String str;
    static String bomb;
    static Stack<Character> chars;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        str = br.readLine();
        bomb = br.readLine();
        chars = new Stack<>();
        
        char target = bomb.charAt(bomb.length() - 1);
        for (int i = 0; i < str.length(); i++) {
            chars.push(str.charAt(i));
            if (chars.peek() == target) {
                check();
            }
        }
        
        while (!chars.isEmpty()) {
            sb.append(chars.pop());
        }
        
        if (sb.length() == 0) {
            System.out.print("FRULA");
        } else {
            System.out.print(sb.reverse().toString());
        }
    }
    
    static void check() {
        if (chars.size() < bomb.length()) return;
        
        boolean isMatch = true;
        
        for (int i = 0; i < bomb.length(); i++) {
            if (chars.get(chars.size() - bomb.length() + i) != bomb.charAt(i)) {
                isMatch = false;
                break;
            }
        }

        if (isMatch) {
            for (int i = 0; i < bomb.length(); i++) {
                chars.pop();
            }
        }
        
    }
}
