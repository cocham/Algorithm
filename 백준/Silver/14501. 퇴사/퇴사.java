import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] times;
    static int[] pays;
    static int maxPay = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N];
        pays = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }
        
        calc(0, 0);
        System.out.print(maxPay);
    }
    
    static void calc(int idx, int sum) {
        
        maxPay = Math.max(sum, maxPay);
        
        for (int i = idx; i < N; i++) {
            if (i + times[i] <= N) {
                calc(i + times[i], sum + pays[i]);
            }
        }
    }
}
