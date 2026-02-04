import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line = br.readLine();
        StringBuilder part = new StringBuilder();
        boolean isTag = false;
        int i = 0;
        while (true) {
            if (i == line.length()) {
                break;
            }
            
            char c = line.charAt(i);
            if (c == '<') {
                if (part.length() != 0) {
                    sb.append(part.reverse().toString());
                    part.setLength(0);
                }
                isTag = true;
                sb.append(c);
            } else if (c == '>') {
                isTag = false;
                sb.append(c);
            } else if (isTag) {
                sb.append(c);
            } else if (c == ' ') {
                sb.append(part.reverse().toString()).append(c);
                part.setLength(0);
            } else {
                part.append(c);
            }
            
            i++;
        }
        
        if (part.length() != 0) {
            sb.append(part.reverse().toString());
        }
        
        System.out.print(sb);
    }
}