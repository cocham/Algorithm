import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("Gnomes:").append('\n');
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if ((a > b && b > c) || (a < b && b < c)) {
                sb.append("Ordered").append('\n');
            } else {
                sb.append("Unordered").append('\n');
            }
        }
        
        System.out.print(sb);
    }
    
}