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
            
            int max = t / 2;
            Map<Long, Integer> soldiers = new HashMap<>();
            
            boolean found = false;
            long idx = -1;

            for (int j = 0; j < t; j++) {
                long soldier = Long.parseLong(st.nextToken());
                int cnt = soldiers.getOrDefault(soldier,0) + 1;
                soldiers.put(soldier, cnt);
                if (cnt > max) {
                    idx = soldier;
                    found = true;
                    break;
                }
            } 
            
            if (found) {
                sb.append(idx).append('\n');
            } else {
                sb.append("SYJKGW").append('\n');
            }
        }
        
        System.out.print(sb);
    }
}