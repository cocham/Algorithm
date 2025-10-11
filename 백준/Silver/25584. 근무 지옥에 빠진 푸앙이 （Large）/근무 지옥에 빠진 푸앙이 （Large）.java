import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] time = {4, 6, 4, 10};
        Map<String, Integer> work = new HashMap<>();
        for (int i = 0; i < n * 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int d = 0; d < 7; d++) {
                String name = st.nextToken();
                if (!name.equals("-")) {
                    work.put(name, work.getOrDefault(name, 0) + time[i % 4]);
                }
            }
        }
        
        if (work.isEmpty()){
            System.out.print("Yes");
        } else {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
            for (int v : work.values()) {
                if (v < min) {
                    min = v;
                } 
                if (v > max) {
                    max = v;
                }
            }
            
            System.out.print(max - min <= 12 ? "Yes" : "No");
        }
    }
}