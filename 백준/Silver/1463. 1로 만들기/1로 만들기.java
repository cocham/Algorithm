import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] results = new int[n + 1];
        Arrays.fill(results, 0);
        
        for (int i = 2; i <= n; i++) {
            results[i] = results[i - 1] + 1;
            
            if (i % 2 == 0) {
                results[i] = Math.min(results[i], results[i/2] + 1);
            }
            
            if (i % 3 == 0) {
                results[i] = Math.min(results[i], results[i/3] + 1);
            }
        }
        
        System.out.print(results[n]);
        
    }
}