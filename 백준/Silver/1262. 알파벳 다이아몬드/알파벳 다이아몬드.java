import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R1, C1, R2, C2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());
        
        int width = N * 2 - 1;
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                int r = i % width;
                int c = j % width;
                
                int dist = Math.abs(r - (N - 1)) + Math.abs(c - (N - 1));
                
                if (dist < N) {
                    sb.append((char)('a' + (dist % 26)));
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}