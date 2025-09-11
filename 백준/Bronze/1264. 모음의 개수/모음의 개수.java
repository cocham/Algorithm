import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null && !line.equals("#")) {
            int cnt = 0;
            
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        
        System.out.print(sb);
    }
}