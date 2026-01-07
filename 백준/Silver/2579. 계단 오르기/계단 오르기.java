import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] scores = new int[n + 1]; 
        int[] results = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        
        results[1] = scores[1];
        
        if (n >= 2) {
            results[2] = scores[1] + scores[2];
        }
        
        for (int i = 3; i <= n; i++) {
            results[i] = Math.max(results[i - 2], results[i - 3] + scores[i - 1]) + scores[i];
        }
        
        System.out.print(results[n]);
        
    }
}