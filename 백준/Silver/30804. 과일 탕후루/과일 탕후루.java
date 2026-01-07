import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] fruits = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
    
        int left = 0;
        int[] counts = new int[10];
        int kind = 0;
        int maxLen = 0;
        
        for (int right = 0; right < n; right++) {
            if (counts[fruits[right]] == 0) {
                kind++;
            }
            
            counts[fruits[right]]++;
            
            while (kind > 2) {
                counts[fruits[left]]--;
                
                if (counts[fruits[left]] == 0) {
                    kind--;
                }
                
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        System.out.print(maxLen);
    }
}
