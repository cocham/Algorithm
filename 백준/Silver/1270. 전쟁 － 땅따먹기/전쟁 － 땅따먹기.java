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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            
            Map<Long, Integer> soldiers = new HashMap<>();
            for (int j = 0; j < t; j++) {
                long soldier = Long.parseLong(st.nextToken());
                soldiers.put(soldier, soldiers.getOrDefault(soldier,0) + 1);
            } 

            int max = t / 2;
            long idx = -1;
            for (Map.Entry<Long, Integer> entry : soldiers.entrySet()) {
                int value = entry.getValue();
                if (value > max) {
                    idx = entry.getKey();
                    break;
                }
            }
            if (idx != -1) {
                sb.append(idx).append('\n');
            } else {
                sb.append("SYJKGW").append('\n');
            }
        }
        
        System.out.print(sb);
    }
}