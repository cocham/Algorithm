import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, String> diseaseMedicine = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String disease = st.nextToken();
            String medicine = st.nextToken();
            diseaseMedicine.put(disease, medicine);
        }
        
        int r = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            boolean died = false;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < l; j++) {
                String disease = st.nextToken();
                if (diseaseMedicine.containsKey(disease)) {
                    temp.append(diseaseMedicine.get(disease)).append(' ');
                } else {
                    sb.append("YOU DIED").append('\n');
                    died = true;
                    break;
                }
            }
            if (!died) {
                sb.append(temp).append('\n');
            }
        }
        
        System.out.print(sb);
    }
}