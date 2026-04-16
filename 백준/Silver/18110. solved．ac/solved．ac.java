import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.print(0);
            return;
        }

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int minus = (int) Math.round(n * 0.15); 
        int level = 0;
        for (int i = minus; i < n - minus; i++) {
            level += arr[i];            
        }
        
        int ans = (int) Math.round((double) level / (n - minus * 2));
        
        System.out.print(ans);
    }
}