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
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> pocketGuide = new HashMap<>();
        String[] pocketNums = new String[n + 1];
       
        for (int i = 1; i <= n; i++) {
            String pocket = br.readLine();
            pocketGuide.put(pocket, i);
            pocketNums[i] = pocket;
        }
        
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                int num = Integer.parseInt(s);
                sb.append(pocketNums[num]).append('\n');
            } else {
                sb.append(pocketGuide.get(s)).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}