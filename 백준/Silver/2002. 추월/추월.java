import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inIndex.put(br.readLine(), i);
        }
        
        int[] outOrder = new int[n];
        for (int j = 0; j < n; j++) {
            outOrder[j] = inIndex.get(br.readLine());
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (outOrder[j] < outOrder[i]) {
                    answer++;
                    break;
                }
            }
        }
        
        System.out.println(answer);
    }
}