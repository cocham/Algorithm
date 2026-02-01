import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        
        int x = 0;
        int y = 0;
        for (int k = 0; k < Math.min(N,K); k++) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == 'U') {
                    x -= 1;
                } else if (S.charAt(i) == 'D') {
                    x += 1;
                } else if (S.charAt(i) == 'L') {
                    y -= 1;
                } else if (S.charAt(i) == 'R') {
                    y += 1;
                }
            
                if (x == 0 && y == 0) {
                    System.out.print("YES");
                    return;
                }
            }
        }
        
        System.out.print("NO");
        
    }
}