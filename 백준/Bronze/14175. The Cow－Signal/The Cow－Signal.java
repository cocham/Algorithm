import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
    
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            StringBuilder newLine = new StringBuilder();
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                newLine.append(String.valueOf(c).repeat(k));
            }
            
            for (int x = 0; x < k; x++) {
                sb.append(newLine).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}