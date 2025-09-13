import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testN = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < testN; i++) {
            int n = Integer.parseInt(br.readLine());
            long r = (long) Math.sqrt(n);
            if (r * r == n) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}