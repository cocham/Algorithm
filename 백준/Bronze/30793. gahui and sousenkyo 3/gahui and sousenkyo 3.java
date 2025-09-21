import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int px = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        
        double vx = (double) px / rx;
        
        if (vx < 0.2) {
            sb.append("weak").append('\n');
        } else if (vx >= 0.2 && vx < 0.4) {
            sb.append("normal").append('\n');
        } else if (vx >= 0.4 && vx < 0.6) {
            sb.append("strong").append('\n');
        } else if (vx >= 0.6) {
            sb.append("very strong").append('\n');
        }
        
        System.out.print(sb);
    } 
}