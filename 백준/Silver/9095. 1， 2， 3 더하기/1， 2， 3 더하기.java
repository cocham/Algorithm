import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int[] results = new int[11];
        results[1] = 1;
        results[2] = 2;
        results[3] = 4;
        
        for (int i = 4; i < 11; i++) {
            results[i] = results[i - 1] + results[i - 2] + results[i - 3];
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(results[n]).append('\n');
        }
        
        System.out.print(sb);
    }
}